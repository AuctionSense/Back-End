package org.auctionsense.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.auctionsense.domain.Bid;
import org.auctionsense.domain.BidHistory;
import org.auctionsense.domain.User;
import org.auctionsense.repository.BidHistoryRepository;
import org.auctionsense.repository.BidRepository;

import io.quarkus.panache.common.Parameters;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import io.vertx.core.json.JsonObject;

@ApplicationScoped
public class BidService {
    @Inject
    BidRepository bidRepository;

    @Inject
    BidHistoryRepository bidHistoryRepository;
    
    @Inject
    UserService userService;
    
    public BidService() {

    }

    public BidHistory getBidHistoryById(UUID id)
    {
        BidHistory bidHistory = bidHistoryRepository.find("#BidHistory.getById", Parameters.with("id", id)).singleResult();
        return bidHistory;
    }

    public List<Bid> getAllBids()
    {
        return bidRepository.listAll();
    }

    @ConsumeEvent("UpdateProductPrice")
    @Transactional
    @Blocking
    public void addBidToHistory(JsonObject body)
    {
        User user = userService.getUserByEmail(body.getString("user"));
        
        BidHistory bidHistory = getBidHistoryById(UUID.fromString(body.getString("bidHistoryId")));

        Bid bid = new Bid();

        bid.setAmount(new BigDecimal(body.getString("amount")));
        bid.setDate(LocalDateTime.now().withNano(0));
        bid.setUser(user);
        bid.setBidHistory(bidHistory);
        try {
            bidRepository.persist(bid);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
}
