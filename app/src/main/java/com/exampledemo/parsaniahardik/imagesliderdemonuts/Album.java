package com.exampledemo.parsaniahardik.imagesliderdemonuts;

/**
 * Created by infoava on 9/18/2017.
 */

public class Album {
        private String name;
        private int numOfSongs;
        private int thumbnail;

        public Album() {
        }

        public Album(String name, int numOfSongs, int thumbnail) {
            this.name = name;
            this.numOfSongs = numOfSongs;
            this.thumbnail = thumbnail;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumOfSongs() {
            return numOfSongs;
        }

        public void setNumOfSongs(int numOfSongs) {
            this.numOfSongs = numOfSongs;
        }

        public int getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(int thumbnail) {
            this.thumbnail = thumbnail;
        }

    /**
     * Created by infoava on 10/12/2017.
     */

    public static class BestDealDetail {

        private String productName;
        private String city;
        private Integer productImg;
        private Integer qantityOrder;
        private Integer price;
        private Integer qantitySolds;

        public BestDealDetail(String productName, String city, Integer productImg, Integer qantityOrder, Integer price, Integer qantitySolds) {
            this.productName = productName;
            this.city = city;
            this.productImg = productImg;
            this.qantityOrder = qantityOrder;
            this.price = price;
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

        public Integer getQantityOrder() {
            return qantityOrder;
        }

        public void setQantityOrder(Integer qantityOrder) {
            this.qantityOrder = qantityOrder;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getQantitySolds() {
            return qantitySolds;
        }

        public void setQantitySolds(Integer qantitySolds) {
            this.qantitySolds = qantitySolds;
        }
    }
}

