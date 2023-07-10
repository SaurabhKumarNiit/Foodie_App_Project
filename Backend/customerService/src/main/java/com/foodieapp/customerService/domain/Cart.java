package com.foodieapp.customerService.domain;
import org.springframework.data.annotation.Id;


public class Cart {
    @Id
    private String itemId;
    private String itemName;
    private double itemPrice;
    private String description;
    private String imagePath;
    private String itemType;
    private int quantity=1;

    public Cart() {
    }

    public Cart(String itemId, String itemName, int itemPrice, String description,
                String imagePath, String itemType, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.description = description;
        this.imagePath = imagePath;
        this.itemType = itemType;
        this.quantity = quantity;
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

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", itemType='" + itemType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}