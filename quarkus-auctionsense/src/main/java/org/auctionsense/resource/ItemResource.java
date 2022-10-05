package org.auctionsense.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.auctionsense.domain.Item;
import org.auctionsense.service.ItemService;

@Path("/api/items")
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

    @POST
    public Response addItem(Item item)
    {
        return itemService.addItem(item);
    }
}
