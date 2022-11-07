package org.auctionsense.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.Category;
import org.auctionsense.repository.CategoryRepository;

@ApplicationScoped
public class CategoryService {
    @Inject 
    CategoryRepository categoryRepository;

    public CategoryService() {

    }

    public List<Category> getAllCategories()
    {
        return categoryRepository.listAll();
    }
}
