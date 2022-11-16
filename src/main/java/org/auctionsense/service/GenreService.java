package org.auctionsense.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.Genre;
import org.auctionsense.repository.GenreRepository;

import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class GenreService {
    @Inject
    GenreRepository genreRepository;

    public GenreService() {

    }

    public List<Genre> getAllGenresByCategoryName(String name) {
        return genreRepository.find("#Genre.getAllGenresByCategoryName", Parameters.with("categoryName", name)).list();
    }
}
