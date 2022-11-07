package org.auctionsense.domain;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
    @Column(precision=6, scale=2)
    private BigDecimal balance;

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

    public BigDecimal getPrice() {
        return balance;
    }

    public void setPrice(BigDecimal balance) {
        this.balance = balance;
    }
}
