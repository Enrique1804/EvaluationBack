package com.evaluation.backend.service;

import com.evaluation.backend.item.Item;
import com.evaluation.backend.item.Location;
import com.evaluation.backend.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ItemServiceImplTest {

    @InjectMocks
    ItemServiceImpl itemServiceImpl;

    @Mock
    ItemRepository itemRepository;

    @Test
    void testGetItemById() {
        Item itemTest = new Item();
        itemTest.setItemId(1919);
        itemTest.setItemName("Pantalones");
        itemTest.setDescription("Azules");
        when(itemRepository.findById(1919)).thenReturn(Optional.of(itemTest));
        Item result = itemServiceImpl.getItemById(1919);
        assertEquals(1919,result.getItemId());
    }

    @Test
    void testGetItemsByState() {
        List<Item> itemsTests = new ArrayList<>();
        Item itemTest = new Item();
        itemTest.setItemId(1919);
        itemTest.setItemName("Pantalones");
        itemTest.setDescription("Azules");
        itemTest.setLocation(new Location("CDMX","23",443311));
        itemsTests.add(itemTest);
        Item itemTest2 = new Item();
        itemTest2.setItemId(2020);
        itemTest2.setItemName("Camisas");
        itemTest2.setDescription("Amarillas");
        itemTest2.setLocation(new Location("EDOMEX","21",332245));
        itemsTests.add(itemTest2);
        String stateTest = "CDMX";
        when(itemRepository.findAll()).thenReturn(itemsTests);
        List<Item> results = itemServiceImpl.getItemsByState(stateTest);
        assertEquals(1,results.size());

    }

    @Test
    void testGetAllItems() {
        List<Item> itemsTests = new ArrayList<>();
        Item itemTest = new Item();
        itemTest.setItemId(1919);
        itemTest.setItemName("Pantalones");
        itemTest.setDescription("Azules");
        itemsTests.add(itemTest);
        Item itemTest2 = new Item();
        itemTest.setItemId(2020);
        itemTest.setItemName("Camisas");
        itemTest.setDescription("Amarillas");
        itemsTests.add(itemTest2);
        when(itemRepository.findAll()).thenReturn(itemsTests);
        List<Item> results = itemServiceImpl.getAllItems();
        assertEquals(2,results.size());
    }

    @Test
    void testPostItem() {
        Item newItem = new Item();
        newItem.setItemName("Calcetines");
        newItem.setDescription("Blancos");

        System.out.println(newItem);
        when(itemRepository.save(newItem)).thenReturn(newItem);
        Item result = itemServiceImpl.postItem(newItem);
        System.out.println(result);
        assertEquals("Calcetines",result.getItemName());
    }

    @Test
    void testDeleteItemById() {
        int itemIdDelete = 1919;
        Item itemTest = new Item();
        itemTest.setItemId(1919);
        itemTest.setItemName("Pantalones");
        itemTest.setDescription("Azules");
        itemServiceImpl.deleteItemById(itemIdDelete);
        verify(itemRepository,times(1)).deleteById(itemIdDelete);
    }

}