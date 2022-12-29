package com.qaprosoft.carina.demo.gui.webtest.common.enums;

public enum Category {
    MIX("CATEGORIES"),
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
