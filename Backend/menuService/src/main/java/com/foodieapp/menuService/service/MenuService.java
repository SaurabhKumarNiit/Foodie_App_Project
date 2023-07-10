package com.foodieapp.menuService.service;

import com.foodieapp.menuService.domain.Item;
import com.foodieapp.menuService.exception.ItemAlreadyExistException;
import com.foodieapp.menuService.exception.ItemNotFoundException;

import java.util.List;

public interface MenuService {

    Item addItem(Item item) throws ItemAlreadyExistException;
    boolean deleteItem(int itemId) throws ItemNotFoundException ;

    boolean deleteAllItems();
    Item updateItem(Item item,int itemId);
    List<Item> getAllItem();

    public Item getItemByItemId(int itemId) throws ItemNotFoundException;
}
