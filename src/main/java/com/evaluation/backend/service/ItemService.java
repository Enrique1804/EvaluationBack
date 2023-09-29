package com.evaluation.backend.service;

import com.evaluation.backend.item.Item;

import java.util.List;

public interface ItemService {

    Item getItemById(int theId);

    List<Item> getItemsByState(String theState);

    List<Item> getAllItems();

    Item postItem(Item theItem);

    void deleteItemById(int theId);

    long getId(int theId);

}
