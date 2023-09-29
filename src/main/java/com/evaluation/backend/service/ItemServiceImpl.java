package com.evaluation.backend.service;

import com.evaluation.backend.item.Item;
import com.evaluation.backend.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item getItemById(int theId) {
        Optional<Item> item = repository.findById(theId);
        if(item.isEmpty()){
            return null;
        }
        return item.get();
    }

    @Override
    public List<Item> getItemsByState(String theState) {
        List<Item> itemsByState = new ArrayList<>();
        List<Item> itemList = repository.findAll();
        for (Item item : itemList){
            if(item.getLocation() != null && theState.equalsIgnoreCase(item.getLocation().getState())){
                itemsByState.add(item);
            }
        }
        return itemsByState;
    }

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item postItem(Item theItem) {
        Item savedItem;
        try {
            savedItem = repository.save(theItem);
        }catch (RuntimeException ex){
            savedItem = null;
        }
        return savedItem;
    }

    @Override
    public void deleteItemById(int theId) {
        repository.deleteById(theId);
    }

    @Override
    public long getId(int theId) {
        boolean existe = repository.existsById(theId);
        System.out.println("ID:" + theId + "Existe: " + existe);
        if (existe){
            return 0;
        }
        else{
            return theId;
        }
    }
}
