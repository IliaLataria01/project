package com.qaprosoft.carina.demo.mobile.gui.pages.utils;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;

public enum MenuOption {
    ALLITEMS("ALL ITEMS", CatalogScreenBase.class),
    WEBVIEW("WEBVIEW", OpenWebViewScreenBase.class),
    QRCODESCANNER("QR CODE SCANNER", ScannerScreenBase.class),
    GEOLOCATION("GEO LOCATION", LocationPermissionsAlertBase.class),
    DRAWING("DRAWING", DrawScreenBase.class),
    ABOUT("ABOUT", AboutScreenBase.class),
    LOGOUT("LOGOUT", LoginScreenBase.class),
    RESETAPPSTATE("RESET APP STATE");

    private String option;

    private Class<? extends AbstractPage> aClass;

    MenuOption(String option) {
        this.option = option;
    }

    MenuOption(String webview, Class<? extends AbstractPage> webViewScreenBaseClass) {
        this.option = webview;
        this.aClass = webViewScreenBaseClass;
    }

    public String getOption() {
        return option;
    }

    public Class<? extends AbstractPage> getaClass() {
        return aClass;
    }
}
