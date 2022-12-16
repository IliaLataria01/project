package com.qaprosoft.carina.demo.gui.test.components;

public enum Category {
    MIX("Mix"),
    PHONES("Phones"),
    LAPTOPS("Laptops"),
    MONITORS("Monitors"),
    ;

    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
