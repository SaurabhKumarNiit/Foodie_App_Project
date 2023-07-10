package com.foodieapp.restaurantService.repository;

import com.foodieapp.restaurantService.domain.Item;
import com.foodieapp.restaurantService.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant,Integer> {

    @Query("{'restaurantName' : {$in : [?0]}}")
    List<Restaurant> findAllRestaurantByRestaurantName(String restaurantName);

    @Query("{'item.itemId' : {$in : [?0]}}")
    Item findAllRestaurantItemsByItemId(int itemId);

    Restaurant findByRestaurantId(int restaurantId);
}
