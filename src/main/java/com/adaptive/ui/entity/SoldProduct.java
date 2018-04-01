package com.adaptive.ui.entity;

public class SoldProduct {
    private String id;
    private String name;

    public SoldProduct(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public SoldProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}