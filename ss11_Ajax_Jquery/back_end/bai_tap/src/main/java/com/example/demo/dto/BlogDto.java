package com.example.demo.dto;

import com.example.demo.model.Category;

public class BlogDto {
    private int id;

    private String name;

    private String producer;
    private String price;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String name, String producer, String price, Category category) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
