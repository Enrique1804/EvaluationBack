package com.evaluation.backend.service;

import com.evaluation.backend.item.Item;
import com.evaluation.backend.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ItemServiceImplTest {

    @InjectMocks
    ItemServiceImpl itemServiceImpl;

    @Mock
    ItemRepository itemRepository;

    @Test
    void getItemById() {
    }

    @Test
    void getItemsByState() {
    }

    @Test
    void getAllItems() {
    }

    @Test
    void postItem() {
    }

    @Test
    void deleteItemById() {
    }

    @Test
    void getId() {
    }
}