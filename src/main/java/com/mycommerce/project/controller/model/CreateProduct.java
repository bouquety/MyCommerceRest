package com.mycommerce.project.controller.model;

public class CreateProduct {
    private String name;
    private String content;
    private float price;

    public CreateProduct() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CreateProduct{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                '}';
    }
}
