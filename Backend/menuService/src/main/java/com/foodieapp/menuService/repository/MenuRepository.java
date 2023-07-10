package com.foodieapp.menuService.repository;

import com.foodieapp.menuService.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<Item,Integer> {
    Item findByItemId(int itemId);
}
