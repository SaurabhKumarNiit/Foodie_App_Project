//package com.foodieapp.restaurantService.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.foodieapp.restaurantService.domain.Item;
//import com.foodieapp.restaurantService.domain.Restaurant;
//import com.foodieapp.restaurantService.exception.RestaurantAlreadyExistException;
//import com.foodieapp.restaurantService.service.RestaurantServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class RestaurantControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private RestaurantServiceImpl restaurantService;
//
//    @InjectMocks
//    private RestaurantController restaurantController;
//
//    Item item = null;
//
//    Restaurant restaurant = null;
//
//    @BeforeEach
//    public void setUp(){
//        List<Item> itemList = new ArrayList<>();
//        Item item1 = new Item(1,"pizza",60.2,"veg");
//        itemList.add(item1);
//        restaurant = new Restaurant(1,"Megha","Pune",itemList);
//        mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
//    }
//
//    @AfterEach
//    public void tearDown(){
//        item = null;
//        restaurant = null;
//    }
//
//    private static String jsonToString(final Object ob) throws JsonProcessingException {
//        String result;
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonContent = mapper.writeValueAsString(ob);
//            result = jsonContent;
//        } catch(JsonProcessingException e) {
//            result = "JSON processing error";
//        }
//
//        return result;
//    }
//
//    @Test
//    public void saveRestaurantTest() throws Exception {
//        when(restaurantService.addRestaurant(any())).thenReturn(restaurant);
//        mockMvc.perform(
//                post("/restaurant/v1/restaurant/addRestaurant").contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(restaurant))).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//        verify(restaurantService,times(1)).addRestaurant(any());
//    }
//
//    @Test
//    public void saveRestaurantFailureTest() throws Exception {
//        when(restaurantService.addRestaurant(any())).thenThrow(RestaurantAlreadyExistException.class);
//        mockMvc.perform(
//                post("/restaurant/v1/restaurant/addRestaurant").contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonToString(restaurant))).andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
//        verify(restaurantService,times(1)).addRestaurant(any());
//    }

//    @Test
//    public void deleteRestaurantTest() throws Exception {
//        when(restaurantService.deleteRestaurant(restaurant.getRestaurantId(),item.getItemId())).thenReturn(restaurant);
//        mockMvc.perform(delete("/restaurant/v1/restaurant/delete/1/1")
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//        verify(restaurantService,times(1)).deleteRestaurant(restaurant.getRestaurantId(),item.getItemId());
//    }
//}
