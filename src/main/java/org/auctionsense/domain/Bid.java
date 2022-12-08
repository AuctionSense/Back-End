package org.auctionsense.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "bids")
public class Bid {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @NotBlank(message = "Amount cannot be blank!")
    private BigDecimal amount;
    @NotBlank(message = "Date cannot be blank")
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid_history_id", foreignKey = @ForeignKey(name = "bid_history_id_fk"))
    private BidHistory bidHistory;

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

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public BidHistory getBidHistory() {
        return bidHistory;
    }
    public void setBidHistory(BidHistory bidHistory) {
        this.bidHistory = bidHistory;
    }
}
