package com.foodieapp.restaurantService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Restaurant {

    @Transient
    public static final String SEQUENCE_NAME="users_sequence";
    @Id
    private int restaurantId;
    private String restaurantName;
    private String restaurantLocation;
    private String imageUrl;
    private String rating;
    private List<Item> itemList;
    private Item item;




    public Restaurant(int restaurantId, String restaurantName,
                      String restaurantLocation,  List<Item> itemList,String imageUrl,String rating,Item item) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantLocation = restaurantLocation;
        this.imageUrl=imageUrl;
        this.rating=rating;
        this.itemList = itemList;
        this.item=item;


    }

    public Restaurant() {
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(String restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantLocation='" + restaurantLocation + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", rating='" + rating + '\'' +
                ", itemList=" + itemList +
                ", item=" + item +
                '}';
    }
}
