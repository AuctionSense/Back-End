package org.auctionsense.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
@NamedQueries({
    @NamedQuery(name = "Items.getByCategory", query = "from Item where category = :category"),
    @NamedQuery(name = "Item.getByName", query = "from Item where name = :name")
})
public class Item {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @NotBlank(message = "Item needs to have a name.")
    private String name;
    @NotBlank(message = "Item needs a description.")
    private String description;
    private String category;

    public Item()
    {

    }

    public Item(String name, String description)
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
