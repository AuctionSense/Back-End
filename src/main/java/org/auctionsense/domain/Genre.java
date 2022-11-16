package org.auctionsense.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.getAllGenresByCategoryId", query = "select new Genre(g.id, g.name) from Genre as g " +
        "join g.categories as c " +
        "where c.id = :categoryId"),
        @NamedQuery(name = "Genre.getAllGenresByCategoryName", query = "select new Genre(g.id, g.name) from Genre as g " +
        "join g.categories as c " +
        "where c.name = :categoryName"),
})
public class Genre {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @NotBlank(message = "Name cannot be blank.")
    private String name;
    @ManyToMany(mappedBy = "genres", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public List<Category> categories;

    public Genre() {
    }

    public Genre(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
