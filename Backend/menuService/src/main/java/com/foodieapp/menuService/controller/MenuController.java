package com.foodieapp.menuService.controller;

import com.foodieapp.menuService.domain.Item;
import com.foodieapp.menuService.exception.ItemAlreadyExistException;
import com.foodieapp.menuService.exception.ItemNotFoundException;
import com.foodieapp.menuService.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/menu")
public class MenuController {
    ResponseEntity responseEntity ;
    @Autowired
    private MenuService menuService;

    //  http://localhost:9001/menu/addItem
    @PostMapping("/addItem")
    public ResponseEntity<?> addItem(@RequestBody Item item) throws ItemAlreadyExistException{
        Item itemAdded = menuService.addItem(item);

        return new ResponseEntity<>(itemAdded,HttpStatus.CREATED);
    }

    //  http://localhost:9001/menu/getAllItem
    @GetMapping("/getAllItem")
    public ResponseEntity<?> getAllItem(){
        return new ResponseEntity<>(menuService.getAllItem(),HttpStatus.OK);
    }


    // http://localhost:9001/menu/items/itemId
    @GetMapping("/items/{itemId}")
    public ResponseEntity<?> getItemByItemId(@PathVariable int itemId ) throws ItemNotFoundException {
        Item item = menuService.getItemByItemId(itemId);
        responseEntity=new ResponseEntity<>(item,HttpStatus.OK);
        return responseEntity;
    }
    //  http://localhost:9001/menu/updateItem/{itemId}
    @PutMapping("/updateItem/{itemId}")
    public ResponseEntity<?> updateItem(@RequestBody Item item,@PathVariable int itemId) {
        return new ResponseEntity<>(menuService.updateItem(item,itemId),HttpStatus.CREATED);
    }

    //  http://localhost:9001/menu/deleteItem/{itemId}
    @DeleteMapping("/deleteItem/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable("itemId") int itemId) throws ItemNotFoundException{
        try {
            menuService.deleteItem(itemId);
            responseEntity = new ResponseEntity<>("Successfully Deleted 1 Record",HttpStatus.OK);
        }catch (ItemNotFoundException e){
            throw new ItemNotFoundException();
        }
        return responseEntity;
    }

  //  http://localhost:9001/menu/deleteAll
    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllItems(){

        responseEntity= new ResponseEntity<>(menuService.deleteAllItems(),HttpStatus.OK);
        responseEntity= new ResponseEntity<>("All items Deleted Successfully",HttpStatus.OK);

        return responseEntity;

    }

    }

