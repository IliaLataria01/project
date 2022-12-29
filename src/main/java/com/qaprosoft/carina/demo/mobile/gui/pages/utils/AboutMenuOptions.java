package com.qaprosoft.carina.demo.mobile.gui.pages.utils;

public enum AboutMenuOptions {
    SOLUTIONS("Solutions"),
    PLATFORM("Platform"),
    PRICING("Pricing"),
    RESOURCES("Resources"),
    COMPANY("Company"),
    CONTACT("Contact");

    private String option;

    AboutMenuOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
