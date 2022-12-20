package com.qaprosoft.carina.demo.mobile.gui.pages.utils;

public enum MenuOptions {
    ALLITEMS("ALL ITEMS"),
    WEBVIEW("WEBVIEW"),
    QRCODESCANNER("QR CODE SCANNER"),
    GEOLOCATION("GEO LOCATION"),
    DRAWING("DRAWING"),
    ABOUT("ABOUT"),
    LOGOUT("LOGOUT"),
    RESETAPPSTATE("RESET APP STATE");

    private String option;

    MenuOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
