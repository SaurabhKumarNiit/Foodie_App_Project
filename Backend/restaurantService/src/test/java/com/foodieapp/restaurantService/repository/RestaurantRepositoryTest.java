//package com.foodieapp.restaurantService.repository;
//
//import com.foodieapp.restaurantService.domain.Item;
//import com.foodieapp.restaurantService.domain.Restaurant;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class RestaurantRepositoryTest {
//
//    @Autowired RestaurantRepository restaurantRepository;
//
//    private Item item;
//    private Restaurant restaurant;
//
//    @BeforeEach
//    public void setUp(){
//        List<Item> itemList = new ArrayList<>();
//        Item item1 = new Item(1,"pizza",60.2,"veg");
//        itemList.add(item1);
//        restaurant = new Restaurant(1,"Megha","Pune",itemList);
//    }
//
//    @AfterEach
//    public void tearDown(){
//        item = null;
//        restaurant = null;
//        restaurantRepository = null;
//    }
//
//    @Test
//    @DisplayName("Test case for save restaurant")
//    public void saveRestaurant(){
//        restaurantRepository.save(restaurant);
//        Restaurant restaurant1 = restaurantRepository.findById(restaurant.getRestaurantId()).get();
//        assertNotNull(restaurant1);
//        assertEquals(restaurant.getRestaurantId(),restaurant1.getRestaurantId());
//    }
//
//    @Test
//    @DisplayName("Test case for retreiving all restaurant")
//    public void fetchRestaurantTest(){
//        restaurantRepository.insert(restaurant);
//        List<Restaurant> list = restaurantRepository.findAll();
//        assertEquals(1,list.size());
//        assertEquals("Megha",list.get(0).getRestaurantName());
//    }
//
//    @Test
//    @DisplayName("Test case for deleting restaurant")
//    public void deleteTrackTest(){
//        Restaurant restaurant1 = restaurantRepository.findById(restaurant.getRestaurantId()).get();
//        restaurantRepository.delete(restaurant1);
//        assertEquals(Optional.empty(),restaurantRepository.findById(restaurant.getRestaurantId()));
//    }
//}
