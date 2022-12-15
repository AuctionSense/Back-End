package org.auctionsense.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.Bid;
import org.auctionsense.domain.BidHistory;
import org.auctionsense.domain.Product;
import org.auctionsense.domain.User;
import org.auctionsense.repository.ProductRepository;

import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class ProductService {
    @Inject 
    ProductRepository productRepository;

    @Inject
    EventBus eventBus;

    @Inject
    UserService userService;

    public ProductService()
    {

    }

    public List<Product> getAllProductsByCategory(String category)
    {
        return productRepository.find("#Products.getByCategory", Parameters.with("category", category).map()).list();
    }

    public Product getProductByName(String name)
    {
        return productRepository.find("#Product.getByName", Parameters.with("name", name).map()).firstResult();
    }

    public Uni<String> updateProductPrice(String name, HashMap<String, String> body)
    {        
        Product currentProduct = productRepository.find("#Product.getByName", Parameters.with("name", name).map()).firstResult();
        BigDecimal amount = new BigDecimal(body.get("amount"));

        if (amount.compareTo(currentProduct.getPrice()) != 1)
        {
            return Uni.createFrom().item("Current bid is smaller than previous bid and therfore invalid.");
        }
        
        BidHistory bidHistory = currentProduct.getBidHistory();
        List<Bid> bids = bidHistory.getBids();

        if (!bids.isEmpty())
        {
            User userHighestBid = bids.get(bids.size() - 1).getUser();
            if (userHighestBid.getEmail().equals(body.get("user")))
            {
                return Uni.createFrom().item("Cannot bid again if you are already the highest bidder.");
            } 
        } 
        
        if (body.get("user").equals("undefined"))
        {
            return Uni.createFrom().item("Cannot bid on items if you are not logged in.");
        }

        User user = userService.getUserByEmail(body.get("user"));

        if (user.getBalance().compareTo(new BigDecimal(body.get("amount"))) < 0)
        {
            return Uni.createFrom().item("You do not have enough balance, you have to add more if you want to bid on this item.");
        }
        
        JsonObject json = JsonObject.mapFrom(body);
        json.put("bidHistoryId", bidHistory.getId().toString());
        eventBus.publish("UpdateProductPrice", json);

        try {
            productRepository.update("#Product.updatePrice", Parameters.with("name", currentProduct.getName()).and("price", amount));
            return Uni.createFrom().item("{\"message\": \"You are now the highest bidder.\"}");
        }
        catch (Exception error) {
            return Uni.createFrom().item(String.format("{\"message\": \"%s\"}", error.getMessage()));
        }
    }
}

