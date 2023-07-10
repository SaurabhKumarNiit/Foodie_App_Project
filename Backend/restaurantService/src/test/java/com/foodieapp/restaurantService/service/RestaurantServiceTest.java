//package com.foodieapp.restaurantService.service;
//
//import com.foodieapp.restaurantService.domain.Item;
//import com.foodieapp.restaurantService.domain.Restaurant;
//import com.foodieapp.restaurantService.exception.ItemNotFoundException;
//import com.foodieapp.restaurantService.exception.RestaurantAlreadyExistException;
//import com.foodieapp.restaurantService.exception.RestaurantNotFoundException;
//import com.foodieapp.restaurantService.repository.RestaurantRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class RestaurantServiceTest {
//
//    @Mock
//    private RestaurantRepository restaurantRepository;
//
//    @InjectMocks
//    private RestaurantServiceImpl restaurantService;
//
//    private Item item;
//
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
//    }
//
//    @Test
//    public void saveRestaurantTest() throws RestaurantAlreadyExistException {
//        when(restaurantRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(null));
//        when(restaurantRepository.save(any())).thenReturn(restaurant);
//        assertEquals(restaurant,restaurantService.addRestaurant(restaurant));
//        verify(restaurantRepository,times(1)).save(any());
//        verify(restaurantRepository,times(1)).findById(any());
//    }
//
//    @Test
//    public void saveRestaurantFailureTest(){
//        when(restaurantRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(restaurant));
//        assertThrows(RestaurantAlreadyExistException.class,()-> restaurantService.addRestaurant(restaurant));
//        verify(restaurantRepository,times(0)).save(any());
//        verify(restaurantRepository,times(1)).findById(any());
//    }
//
////    @Test
////    public void deleteRestaurantTest() throws RestaurantNotFoundException, ItemNotFoundException {
////        when(restaurantRepository.findById(restaurant.getRestaurantId())).thenReturn(Optional.ofNullable(restaurant));
////        Restaurant flag = restaurantService.deleteRestaurant(restaurant.getRestaurantId(),item.getItemId());
////        assertEquals(restaurant,flag);
////        verify(restaurantRepository,times(1)).deleteById(any());
////        verify(restaurantRepository,times(1)).findById(any());
////    }
//}
