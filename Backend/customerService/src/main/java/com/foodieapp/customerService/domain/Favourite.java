package com.foodieapp.customerService.domain;

import org.springframework.data.annotation.Id;


public class Favourite {
    @Id
    private String itemId;
    private String itemName;
    private String restaurantName;
    private String description;
    private String itemType;
    private String imagePath;


    public Favourite() {
    }

    public Favourite(String restaurantName, String description, String itemId,
                     String imagePath, String itemType, String itemName) {
        this.restaurantName = restaurantName;
        this.description = description;
        this.itemId = itemId;
        this.imagePath = imagePath;
        this.itemType = itemType;
        this.itemName=itemName;
    }



    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", description='" + description + '\'' +
                ", itemType='" + itemType + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
