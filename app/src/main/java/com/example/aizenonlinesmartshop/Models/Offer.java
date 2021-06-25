package com.example.aizenonlinesmartshop.Models;

public class Offer {

    private int offerImage;
    private String product_name;
    private String offerDetail;

    public Offer(int offerImage, String product_name, String offerDetail) {
        this.offerImage = offerImage;
        this.product_name = product_name;
        this.offerDetail = offerDetail;
    }

    public int getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(int offerImage) {
        this.offerImage = offerImage;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getOfferDetail() {
        return offerDetail;
    }

    public void setOfferDetail(String offerDetail) {
        this.offerDetail = offerDetail;
    }
}
