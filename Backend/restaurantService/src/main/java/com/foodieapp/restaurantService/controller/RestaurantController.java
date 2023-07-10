package com.foodieapp.restaurantService.controller;

import com.foodieapp.restaurantService.domain.Item;
import com.foodieapp.restaurantService.domain.Restaurant;
import com.foodieapp.restaurantService.exception.ItemAlreadyExistException;
import com.foodieapp.restaurantService.exception.ItemNotFoundException;
import com.foodieapp.restaurantService.exception.RestaurantAlreadyExistException;
import com.foodieapp.restaurantService.exception.RestaurantNotFoundException;
import com.foodieapp.restaurantService.service.RestaurantService;
import com.foodieapp.restaurantService.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static com.foodieapp.restaurantService.domain.Restaurant.SEQUENCE_NAME;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/restaurant/v1/")
public class RestaurantController {

    private ResponseEntity responseEntity;
    private RestaurantService restaurantService;
    private SequenceGeneratorService generatorService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService,SequenceGeneratorService generatorService)
    {
        this.restaurantService=restaurantService;
        this.generatorService=generatorService;
    }

    //  http://localhost:9088/restaurant/v1/restaurant/addRestaurant
    @PostMapping("/restaurant/addRestaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) throws  RestaurantAlreadyExistException
    {
        restaurant.setRestaurantId((int) generatorService.generateSequence(SEQUENCE_NAME));
        return new ResponseEntity<>(restaurantService.addRestaurant(restaurant),HttpStatus.CREATED);

    }


    //  http://localhost:9088/restaurant/v1/restaurant/delete/{restaurantId}/{itemId}
    @DeleteMapping("/restaurant/delete/{restaurantId}/{itemId}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable("restaurantId") int restaurantId, @PathVariable int itemId) throws RestaurantNotFoundException, ItemNotFoundException {

        try{
//            restaurantService.deleteRestaurant(restaurantId);
            responseEntity=new ResponseEntity<>(restaurantService.deleteRestaurant(restaurantId,itemId),HttpStatus.OK);

        }catch (RestaurantNotFoundException e){

            throw new RestaurantNotFoundException();

        }catch (ItemNotFoundException e){
            throw new ItemNotFoundException();
            //responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    //  http://localhost:9088/restaurant/v1/restaurant/{restaurantName}
    @GetMapping("/restaurant/{restaurantName}")
    public ResponseEntity<?> getAllRestaurantByRestaurantName(@PathVariable String restaurantName) throws RestaurantNotFoundException {
        try {
            responseEntity = new ResponseEntity(restaurantService.getAllRestaurantByRestaurantName(restaurantName), HttpStatus.CREATED);

        } catch ( RestaurantNotFoundException e) {
            throw new RestaurantNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    //  http://localhost:9088/restaurant/v1/restaurant/addMenu/{restaurantId}
    @PutMapping("/restaurant/addMenu/{restaurantId}")
    public ResponseEntity<?> addItemForRestaurant(@PathVariable int restaurantId, @RequestBody Item item) throws ItemAlreadyExistException {

        try{
            //Restaurant restaurant =restaurantService.addMenuForRestaurant(restaurantId, item);
            responseEntity=new ResponseEntity<>(restaurantService.addMenuForRestaurant(restaurantId, item),HttpStatus.OK);

        } catch (ItemAlreadyExistException e) {
            throw new ItemAlreadyExistException();
        }

        return responseEntity;
    }


    //  http://localhost:9088/restaurant/v1/{restaurantId}
    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getAllItemsByRestaurantId(@PathVariable int restaurantId){

        responseEntity=new ResponseEntity<>(restaurantService.getAllRestaurantItems(restaurantId),HttpStatus.CREATED);
        return responseEntity;
    }

//  http://localhost:9088/restaurant/v1/getAllRestaurant
    @GetMapping("/getAllRestaurant")
    public ResponseEntity<?> getAllRestaurant(){
        responseEntity=new ResponseEntity<>(restaurantService.getAllRestaurant(),HttpStatus.CREATED);
        return responseEntity;
    }

  //  http://localhost:9088/restaurant/v1/getRest/{data}
    @GetMapping(path = "/getRest/{restId}")
    public ResponseEntity<?> getRestaurants(@PathVariable int restId)throws RestaurantNotFoundException{

        Restaurant restaurant = restaurantService.getSingleRestaurant(restId);
        return responseEntity = new ResponseEntity(restaurant,HttpStatus.OK);
    }

    //  http://localhost:9088/restaurant/v1/restaurant/delete/{restaurantId}
    @DeleteMapping("/restaurant/delete/{restaurantId}")
    public ResponseEntity<?> deleteSingleRestaurant(@PathVariable int restaurantId) throws RestaurantNotFoundException {
        try{
         responseEntity= new ResponseEntity<>(restaurantService.deleteSingleRestaurant(restaurantId),HttpStatus.OK)  ;
        }catch (RestaurantNotFoundException e){
            throw new RestaurantNotFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    //  http://localhost:9088/restaurant/v1/updateRestaurant/{restaurantId}
    @PutMapping("/updateRestaurant/{restaurantId}")
    public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant,@PathVariable int restaurantId) throws RestaurantNotFoundException {
        try {
            return new ResponseEntity<>(restaurantService.updateRestaurantDetails(restaurant,restaurantId),HttpStatus.CREATED);
        } catch (RestaurantNotFoundException e) {
            throw new RestaurantNotFoundException();
        }
    }

    //  http://localhost:9088/restaurant/v1/restaurantItem/update/{restaurantId}
    @PutMapping("/restaurantItem/update/{restaurantId}")
    public ResponseEntity<?> updateRestaurantItem(@PathVariable int restaurantId, @RequestBody Item item) throws RestaurantNotFoundException {
        responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(restaurantService.updateRestaurantItem(restaurantId, item), HttpStatus.CREATED);
        } catch (RestaurantNotFoundException e) {
            throw new RestaurantNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}

