//package com.foodieapp.menuService.repository;
//
//
//import com.foodieapp.menuService.domain.Item;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class MenuRepositoryTest {
//
//    @Autowired
//    private MenuRepository menuRepository;
//
//    private Item item;
//
//    @BeforeEach
//    public void setUp(){
//
//        item = new Item(1,"Hakka Noodles",250,"Chinese");
//    }
//
//    @Test
//    @DisplayName("Test case for adding item")
//    void givenItemToAddShouldAddItem(){
//        menuRepository.save(item);
//        Item item1 = menuRepository.findById(item.getItemId()).get();
//        assertNotNull(item1);
//        assertEquals(item.getItemId(), item1.getItemId());
//    }
//
//    @Test
//    @DisplayName("Test case for get all item")
//    void givenItemReturnAllItemDetails(){
//
//        menuRepository.insert(item);
//        Item item1 = new Item(2,"Palak Paneer",350,"North Indian");
//        menuRepository.insert(item1);
//
//        List<Item> list = menuRepository.findAll();
//        assertEquals(2,list.size());
//        assertEquals("Palak Paneer",list.get(1).getItemName());
//    }
//
//    @Test
//    @DisplayName("Test case for deleting item")
//    void givenItemToDeleteShouldDeleteItem(){
//        menuRepository.insert(item);
//        Item item1 = menuRepository.findById(item.getItemId()).get();
//        menuRepository.delete(item1);
//        assertEquals(Optional.empty(),menuRepository.findById(item.getItemId()));
//    }
//
//
//    @AfterEach
//    void tearDown() {
//
//        item = null;
//        menuRepository.deleteAll();
//
//    }
//}
//
