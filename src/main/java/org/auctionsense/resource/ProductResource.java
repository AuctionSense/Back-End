package org.auctionsense.resource;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.auctionsense.domain.Product;
import org.auctionsense.service.ProductService;

import io.smallrye.mutiny.Uni;

@Path("/api/all/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    @Inject
    private ProductService productService;

    public ProductResource()
    {

    }

    @GET
    @Path("/category/{category}")
    public List<Product> getAllProductsByCategory(String category)
    {
        return productService.getAllProductsByCategory(category);
    }
    
    @GET
    @Path("/name/{name}")
    public Product getProductByName(String name)
    {
        return productService.getProductByName(name);
    }

    @PUT
    @Transactional
    @Path("/name/{name}")
    public Uni<String> updateProductPrice(String name, HashMap<String, String> body)
    {
        return productService.updateProductPrice(name, body);
    }
}
