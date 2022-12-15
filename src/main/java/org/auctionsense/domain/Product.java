package org.auctionsense.domain;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "products")
@NamedQueries({
    @NamedQuery(name = "Products.getByCategory", query = "from Product p " +
    "where p.category.name = :category"),
    @NamedQuery(name = "Product.getByName", query = "from Product where name = :name"),
    @NamedQuery(name = "Product.updatePrice", query = "update Product set price = :price where name = :name"),
})
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @NotBlank(message = "Product needs to have a name.")
    private String name;
    @NotBlank(message = "Product needs a description.")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "category_id_fk"))
    private Category category;
    @Column(precision=6, scale=2)
    private BigDecimal price;
    @OneToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "bid_history_id")
    private BidHistory bidHistory;

    public Product()
    {

    }

    public Product(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal currentPrice) {
        this.price = currentPrice;
    }

    public BidHistory getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(BidHistory bidHistory) {
        this.bidHistory = bidHistory;
    }
}
