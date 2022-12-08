package org.auctionsense.service;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.BidHistory;
import org.auctionsense.repository.BidHistoryRepository;
import org.auctionsense.repository.BidRepository;

import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class BidService {
    @Inject
    BidRepository bidRepository;

    @Inject
    BidHistoryRepository bidHistoryRepository;
    
    public BidService() {

    }

    public BidHistory getBidHistoryById(UUID id)
    {
        return bidHistoryRepository.find("#BidHistory.getById", Parameters.with("id", id)).firstResult();
    }
}
