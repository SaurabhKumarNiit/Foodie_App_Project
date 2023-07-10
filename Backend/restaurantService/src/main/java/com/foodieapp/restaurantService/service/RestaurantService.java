package com.foodieapp.restaurantService.service;

import com.foodieapp.restaurantService.domain.Item;
import com.foodieapp.restaurantService.domain.Restaurant;
import com.foodieapp.restaurantService.exception.ItemAlreadyExistException;
import com.foodieapp.restaurantService.exception.ItemNotFoundException;
import com.foodieapp.restaurantService.exception.RestaurantAlreadyExistException;
import com.foodieapp.restaurantService.exception.RestaurantNotFoundException;

import java.util.List;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException;

    Restaurant deleteRestaurant(int restaurantId,int itemId) throws RestaurantNotFoundException, ItemNotFoundException;

    List<Restaurant> getAllRestaurantByRestaurantName(String restaurantName) throws RestaurantNotFoundException;

    List<Restaurant> getAllRestaurant();

    public Restaurant addMenuForRestaurant(int restaurantId, Item item) throws ItemAlreadyExistException;

    List<Item> getAllRestaurantItems(int restaurantId) ;

    Restaurant getSingleRestaurant(int restId)throws RestaurantNotFoundException;

    boolean deleteSingleRestaurant(int restaurantId) throws RestaurantNotFoundException;

    Item getSingleItem(int itemId) throws ItemNotFoundException;

    Restaurant updateRestaurantDetails(Restaurant restaurant, int restaurantId) throws RestaurantNotFoundException ;

    public Restaurant updateRestaurantItem(int restaurantId, Item item) throws RestaurantNotFoundException;

}
