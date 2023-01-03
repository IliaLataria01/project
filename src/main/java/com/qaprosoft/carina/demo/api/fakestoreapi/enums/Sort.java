package com.qaprosoft.carina.demo.api.fakestoreapi.enums;

public enum Sort {
    ASCENDING("asc"),
    DESCENDING("desc");

    private String sort;
    Sort(String asc) {
        this.sort = asc;
    }

    public String getSort() {
        return sort;
    }
}
