package com.evaluation.backend.controller;

import com.evaluation.backend.dao.AppDao;
import com.evaluation.backend.dao.AppDaoImpl;
import com.evaluation.backend.item.Item;
import com.evaluation.backend.service.ItemService;
import com.evaluation.backend.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    @Autowired
    private AppDao service;

    @PostMapping("/items")
    public Item createItem(Item item){
        return service.postItem(item);
    }

}
