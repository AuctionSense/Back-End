package org.auctionsense.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import utils.CustomSerializer;

@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.getByEmail", query = "from User where email = :email"),
    @NamedQuery(name = "User.updateBalance", query = "update User set balance = :balance where email = :email"),
})
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @NotBlank(message = "Email cannot be blank.")
    private String email;
    @NotBlank(message = "Balance cannot be empty.")
    @Column(precision=6, scale=2, name = "balance")
    private BigDecimal balance;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonSerialize(using = CustomSerializer.class)
    private List<Bid> bids;

    public User() {

    }

    public User(String email, BigDecimal price) {
        this.email = email;
        this.balance = price;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bid) {
        this.bids = bid;
    }
}
