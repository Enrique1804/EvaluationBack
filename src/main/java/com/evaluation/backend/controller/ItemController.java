package com.evaluation.backend.controller;

import com.evaluation.backend.item.Item;
import com.evaluation.backend.service.ItemServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        Item savedItem = service.postItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{itemId}")
                .buildAndExpand(savedItem.getItemId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/items/{theId}")
    public ResponseEntity<Item> retrieveItemById(@PathVariable int theId){
        Item item = service.getItemById(theId);
        if (item != null){
            return new ResponseEntity<>(item, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/items/{theId}")
    public void deleteItem(@PathVariable int theId){
        service.deleteItemById(theId);
    }


}
