package org.auctionsense.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.auctionsense.domain.Product;
import org.auctionsense.repository.ProductRepository;

import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class ProductService {
    @Inject 
    ProductRepository productRepository;

    public ProductService()
    {

    }


    public List<Product> getAllProductsByCategory(String category)
    {
        return productRepository.find("#Products.getByCategory", Parameters.with("category", category).map()).list();
    }

    public Product getProductByName(String name)
    {
        return productRepository.find("#Product.getByName", Parameters.with("name", name).map()).firstResult();
    }
}

