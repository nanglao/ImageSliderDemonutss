package com.exampledemo.parsaniahardik.imagesliderdemonuts;

/**
 * Created by infoava on 10/12/2017.
 */

public class BestDeal_Details {

    private String productName;
    private String city;
    private Integer productImg;
    private Integer price;
    private Integer qantityOrder;
    private Integer qantitySolds;

    public BestDeal_Details(String productName, String city, Integer productImg, Integer price, Integer qantityOrder, Integer qantitySolds) {
        this.productName = productName;
        this.city = city;
        this.productImg = productImg;
        this.price = price;
        this.qantityOrder = qantityOrder;
        this.qantitySolds = qantitySolds;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getProductImg() {
        return productImg;
    }

    public void setProductImg(Integer productImg) {
        this.productImg = productImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQantityOrder() {
        return qantityOrder;
    }

    public void setQantityOrder(Integer qantityOrder) {
        this.qantityOrder = qantityOrder;
    }

    public Integer getQantitySolds() {
        return qantitySolds;
    }

    public void setQantitySolds(Integer qantitySolds) {
        this.qantitySolds = qantitySolds;
    }
}
