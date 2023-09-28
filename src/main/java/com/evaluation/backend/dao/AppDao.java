package com.evaluation.backend.dao;

import com.evaluation.backend.item.Item;

import java.util.List;

public interface AppDao {

    Item getItemById(int theId);

    List<Item> getItemsByState(String theState);

    Item postItem(Item theItem);

    void deleteItemById(int theId);

}
