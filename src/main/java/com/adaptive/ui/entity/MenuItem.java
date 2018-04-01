package com.adaptive.ui.entity;

public class MenuItem {
    private String id;
    private String name;

    public MenuItem() {
    }

    public MenuItem(String name, String id) {
        this.id = id;
        this.name = name;
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
