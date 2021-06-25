package com.example.aizenonlinesmartshop.Models;

public class Item {
    private int image;
    private String item_name;

    public Item(int image, String item_name) {
        this.image = image;
        this.item_name = item_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
