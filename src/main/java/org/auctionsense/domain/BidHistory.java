package org.auctionsense.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bid_history")
@NamedQuery(name = "BidHistory.getById", query = "from BidHistory where id = :id")
public class BidHistory {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @OneToMany(mappedBy = "bidHistory", cascade = CascadeType.ALL)
    private List<Bid> bids = new ArrayList<>();

    public BidHistory() {
        
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}

