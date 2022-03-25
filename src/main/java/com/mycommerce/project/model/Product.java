package com.mycommerce.project.model;

import com.mycommerce.project.controller.model.ProductResponse;

import java.io.Serializable;

public class Product implements Serializable {
    private Long id;
    private String name;
    private String content;
    private float price;

    public Product() {
    }

    Product(Long id, String name, String content, float price) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public Product(String name, String content, float price) {
        this.name = name;
        this.content = content;
        this.price = price;
    }

    public ProductResponse toDto(){
        ProductResponse p = new ProductResponse();
        p.setId(this.id);
        p.setName(this.name);
        p.setContent(this.content);
        p.setPrice(this.price);
        return p;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
