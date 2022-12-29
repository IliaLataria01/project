package com.qaprosoft.carina.demo.mobile.gui.pages.utils;

public enum FilterOption {
    FROM_A_TO_Z("A to Z"),
    FROM_Z_TO_A("Z to A"),
    FROM_LOWER_TO_HIGH("Low to High"),
    FROM_HIGHER_TO_LOWER("High to Low");

    private String option;

    FilterOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
