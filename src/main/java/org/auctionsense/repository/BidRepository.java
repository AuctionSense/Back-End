package org.auctionsense.repository;

import javax.enterprise.context.ApplicationScoped;

import org.auctionsense.domain.Bid;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class BidRepository implements PanacheRepository<Bid> {
    
}
