package org.auctionsense.service;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.auctionsense.domain.Item;
import org.auctionsense.repository.ItemRepository;

@ApplicationScoped
public class ItemService {
    @Inject 
    ItemRepository itemRepository;

    public ItemService()
    {

    }

    public List<Item> getAllItems()
    {
        return itemRepository.listAll();
    }

    public Response addItem(Item item)
    {
        itemRepository.persist(item);
        return Response.created(URI.create("/items/" + item.getId())).build();
    }
}

