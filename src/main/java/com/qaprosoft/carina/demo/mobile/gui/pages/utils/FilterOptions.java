package com.qaprosoft.carina.demo.mobile.gui.pages.utils;

public enum FilterOptions {
    FROMATOZ("A to Z"),
    FROMZTOA("Z to A"),
    FROMLOWERTOHIGH("Low to High"),
    FROMHIGHERTOLOWER("High to Low");

    private String option;

    FilterOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
