package com.example.aizenonlinesmartshop.Models;

public class CartModel {


    int  imageCart;
    String nameProduct;
    String typeProduct;

    public CartModel(int imageCart, String nameProduct, String typeProduct) {
        this.imageCart = imageCart;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
    }

    public int getImageCart() {
        return imageCart;
    }

    public void setImageCart(int imageCart) {
        this.imageCart = imageCart;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }
}
