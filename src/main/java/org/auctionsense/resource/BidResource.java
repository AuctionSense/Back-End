package org.auctionsense.resource;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.auctionsense.domain.Bid;
import org.auctionsense.domain.BidHistory;
import org.auctionsense.service.BidService;

@Path("/api/all/bids")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BidResource {
    @Inject
    BidService bidService;

    public BidResource() {

    }

    @GET
    public List<Bid> getAllBids()
    {
        return bidService.getAllBids();
    }

    @Path("/history/{id}")
    @GET
    public BidHistory getBidHistoryById(UUID id)
    {
        return bidService.getBidHistoryById(id);
    }
}
