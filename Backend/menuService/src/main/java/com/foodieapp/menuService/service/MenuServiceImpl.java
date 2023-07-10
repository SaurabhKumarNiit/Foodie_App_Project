package com.foodieapp.menuService.service;

import com.foodieapp.menuService.domain.Item;
import com.foodieapp.menuService.exception.ItemAlreadyExistException;
import com.foodieapp.menuService.exception.ItemNotFoundException;
import com.foodieapp.menuService.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Item addItem(Item item) throws ItemAlreadyExistException {
       if(menuRepository.findById(item.getItemId()).isPresent())
       {
           throw new ItemAlreadyExistException();
       }
        return menuRepository.save(item);
    }

    @Override
    public boolean deleteItem(int itemId) throws ItemNotFoundException {
        boolean result = false;
        if (menuRepository.findById(itemId).isEmpty()){
            throw new ItemNotFoundException();
        }else{
            menuRepository.deleteById(itemId);
            result = true;
        }
        return result;
    }

    @Override
    public boolean deleteAllItems() {
        menuRepository.deleteAll();
        return true;
    }

    @Override
    public Item updateItem(Item item, int itemId)  {
        Optional<Item> optionalItem = menuRepository.findById(itemId);
        if(optionalItem.isEmpty()){
            return null;
        }
        Item existingItem = optionalItem.get();
        if (item.getItemName()!=null){
            existingItem.setItemName(item.getItemName());
        }
        if (item.getItemPrice()!=0){
            existingItem.setItemPrice(item.getItemPrice());
        }
        if (item.getItemType()!=null){
            existingItem.setItemType(item.getItemType());
        }
        if(item.getImagePath()!=null){
            existingItem.setImagePath(item.getImagePath());
        }
        if(item.getDescription()!=null){
            existingItem.setDescription(item.getDescription());
        }
//        if(item.getQuantity()!=0){
//            existingItem.setQuantity(item.getQuantity());
//        }
        return menuRepository.save(existingItem);
        }

    @Override
    public List<Item> getAllItem()  {
        List<Item> menuRepositoryAll = menuRepository.findAll();
        return menuRepositoryAll;
    }

    @Override
    public Item getItemByItemId(int itemId) throws ItemNotFoundException {
        return menuRepository.findByItemId(itemId);
    }

}
