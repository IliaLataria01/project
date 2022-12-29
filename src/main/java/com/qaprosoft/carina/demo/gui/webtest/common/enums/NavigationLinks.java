package com.qaprosoft.carina.demo.gui.webtest.common.enums;

public enum NavigationLinks {
    HOME("Home"),
    CONTACT("Contact"),
    ABOUT_US("About us"),
    CART("Cart"),
    LOGOUT("Log out"),
    LOGIN("Log in"),
    SIGNIN("Sign up");

    private String link;

    NavigationLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
