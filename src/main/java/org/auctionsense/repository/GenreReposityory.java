package org.auctionsense.repository;

import javax.enterprise.context.ApplicationScoped;

import org.auctionsense.domain.Genre;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class GenreReposityory implements PanacheRepository<Genre> {
    
}
