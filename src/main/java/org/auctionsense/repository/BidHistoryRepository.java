package org.auctionsense.repository;

import javax.enterprise.context.ApplicationScoped;

import org.auctionsense.domain.BidHistory;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BidHistoryRepository implements PanacheRepository<BidHistory> {
    
}
