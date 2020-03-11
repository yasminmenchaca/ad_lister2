package com.codeup.adlister.models;

import java.util.List;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String price;
    private String location;
    private String category;


    public Ad(long id, long userId, String title, String description, String category, String price, String location) {

//    public Ad(long id, long userId, String title, String description, String location) {

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.location = location;
    }

    public Ad(long id, long userId, String title, String description, String price) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;

//        this.location = location;

    }

    public Ad(long userId, String title, String description, String price, String location) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
    }

    public Ad(long userId, String title, String description, String price, String category,String location) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.location = location;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Ad() {}

    public String getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
