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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import utils.CustomSerializer;

@Entity
@Table(name = "bid_history")
@NamedQuery(name = "BidHistory.getById", query = "select bh from BidHistory bh where bh.id = :id")
public class BidHistory {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @OneToMany(mappedBy = "bidHistory", cascade = CascadeType.ALL)
    @JsonSerialize(using = CustomSerializer.class)
    private List<Bid> bids = new ArrayList<>();

    public BidHistory() {
        
    }

    public BidHistory(UUID id, List<Bid> bids) {
        this.id = id;
        this.bids = bids;
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

