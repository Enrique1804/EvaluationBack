package com.evaluation.backend.service;

import com.evaluation.backend.dao.AppDao;
import com.evaluation.backend.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private AppDao dao;

    @Override
    public Item getItemById(long theId) {
        return null;
    }

    @Override
    public List<Item> getItemsByState(String theState) {
        return null;
    }

    @Override
    public void postItem(Item theItem) {

    }

    @Override
    public void deleteItemById(int theId) {

    }
}
