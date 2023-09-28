package com.evaluation.backend.service;

import com.evaluation.backend.item.Item;

import java.util.List;

public interface ItemService {

    Item getItemById(long theId);

    List<Item> getItemsByState(String theState);

    void postItem(Item theItem);

    void deleteItemById(int theId);

}
