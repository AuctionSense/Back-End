package org.auctionsense.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.Category;
import org.auctionsense.repository.CategoryRepository;
import org.auctionsense.repository.GenreRepository;

import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class CategoryService {
    @Inject 
    CategoryRepository categoryRepository;

    @Inject
    GenreRepository genreRepository;

    public CategoryService() {

    }

    public List<Category> getAllCategories()
    {
        List<Category> categories = categoryRepository.listAll();
        for (Category category : categories) {
            category.setGenres(genreRepository.find("#Genre.getAllGenresByCategoryId", Parameters.with("categoryId", category.getId())).list());
        }
        return categories;
    }
}
