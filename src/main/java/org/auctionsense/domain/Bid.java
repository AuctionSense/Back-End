package org.auctionsense.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "bids")
public class Bid {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private BigDecimal amount;
    private LocalDateTime date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid_history_id", foreignKey = @ForeignKey(name = "bid_history_id_fk"))
    private BidHistory bidHistory;

    public Bid() {
        
    }

    public Bid(UUID id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BidHistory getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(BidHistory bidHistory) {
        this.bidHistory = bidHistory;
    }
}
