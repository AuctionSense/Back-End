package org.auctionsense.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.auctionsense.domain.Category;
import org.auctionsense.service.CategoryService;

@Path("/api/all/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {
    @Inject
    CategoryService categoryService;

    public CategoryResource() {
        
    }

    @GET
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategories();
    }
}
