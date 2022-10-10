package org.auctionsense.service;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.auctionsense.domain.Item;
import org.auctionsense.repository.ItemRepository;

import io.quarkus.panache.common.Parameters;

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

    public List<Item> getAllItemsByCategory(String category)
    {
        return itemRepository.find("#Items.getByCategory", Parameters.with("category", category).map()).list();
    }

    public Item getItemById(UUID id)
    {
        return itemRepository.find("#Item.getById", Parameters.with("id", id).map()).firstResult();
    }

    public Response addItem(Item item)
    {
        itemRepository.persist(item);
        return Response.created(URI.create("/items/" + item.getId())).build();
    }


}

