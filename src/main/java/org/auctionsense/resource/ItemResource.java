package org.auctionsense.resource;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.auctionsense.domain.Item;
import org.auctionsense.service.ItemService;

@Path("/api/items")
@Produces("application/json")
@Consumes("application/json")
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
    @Path("/id={id}")
    public Item getItemById(@PathParam("id") UUID id)
    {
        return itemService.getItemById(id);
    }

    @POST
    public Response addItem(Item item)
    {
        return itemService.addItem(item);
    }
}