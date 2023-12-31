package com.evaluation.backend.controller;

import com.evaluation.backend.item.Item;
import com.evaluation.backend.service.ItemServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private ItemServiceImpl service;

    public ItemController(ItemServiceImpl service){
        this.service = service;
    }

    @GetMapping("/items")
    public List<Item> retrieveAllItems(@RequestParam(required = false) String state){
        if (state != null){
            return service.getItemsByState(state);
        }else{
            return service.getAllItems();
        }
    }

    @PostMapping("/items")
    public ResponseEntity<Object> createItem(@Valid @RequestBody Item item){
        int exist = (int)item.getItemId();
        long existeId = service.getId(exist);
        if (existeId != 0){
            Item savedItem = service.postItem(item);
            if (savedItem == null){
                return ResponseEntity.badRequest().build();
                //return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<Object>(HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<Object>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/items/{theId}")
    public ResponseEntity<Item> retrieveItemById(@PathVariable int theId){
        Item item = service.getItemById(theId);
        if (item != null){
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }else {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/items/{theId}")
    public ResponseEntity<Item> deleteItem(@PathVariable int theId){
        Item item = service.getItemById(theId);
        if (item == null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        service.deleteItemById(theId);
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }
}
