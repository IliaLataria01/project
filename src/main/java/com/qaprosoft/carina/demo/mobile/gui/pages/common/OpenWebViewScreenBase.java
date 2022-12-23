package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OpenWebViewScreenBase extends AbstractPage {
    public OpenWebViewScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isURLFieldPresent();

    public abstract void typeURL(String url);

    public abstract WebViewScreenBase clickGoToSiteButton();

    public abstract boolean isGoToButtonPresent();

}
