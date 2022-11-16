package org.auctionsense.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.auctionsense.domain.Genre;
import org.auctionsense.service.GenreService;

@Path("/api/all/genres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GenreResource {
    @Inject
    GenreService genreService;

    public GenreResource() {

    }

    @GET
    @Path("/category/{name}")
    public List<Genre> getAllGenresByName(String name)
    {
        return genreService.getAllGenresByCategoryName(name);
    }
}
