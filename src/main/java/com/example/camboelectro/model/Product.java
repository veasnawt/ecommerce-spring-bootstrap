package com.example.camboelectro.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @Column(nullable = true)
    private float oldPrice;

    @Column(nullable = true) 
    private float ratings;

    @Column(nullable = true)
    private long noRatings;

    @Column(columnDefinition = "LONGTEXT", nullable = true)
    private String description;

    @Column(nullable = false)
    private ArrayList<String> imageUrls;

    @Column(nullable = false)
    private long storeId;

    @Column(nullable = true)
    private String color;

    @Column(nullable = false)
    private long categoryId;

    @Column(nullable = true)
    private long ranking;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public long getNoRatings() {
        return noRatings;
    }

    public void setNoRatings(long noRatings) {
        this.noRatings = noRatings;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long isRanking() {
        return ranking;
    }

    public void setRanking(int i) {
        this.ranking = i;
    }
}
