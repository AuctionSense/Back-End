package org.auctionsense.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.auctionsense.domain.Item;
import org.auctionsense.service.ItemService;

@Path("/api/all/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Inject
    private ItemService itemService;

    public ItemResource()
    {

    }

    @GET
    public List<Item> getAllItems()
    {
        return itemService.getAllItems();
    }

    @GET
    @Path("/category={category}")
    public List<Item> getAllItemsByCategory(@PathParam("category") String category)
    {
        return itemService.getAllItemsByCategory(category);
    }
    
    @GET
    @Path("/name={name}")
    public Item getItemByName(@PathParam("name") String name)
    {
        return itemService.getItemByName(name);
    }

    @POST
    public Response addItem(Item item)
    {
        return itemService.addItem(item);
    }
}
