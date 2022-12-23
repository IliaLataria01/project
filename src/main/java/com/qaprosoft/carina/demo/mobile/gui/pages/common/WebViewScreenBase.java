package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewScreenBase extends AbstractPage {
    public WebViewScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoPresent();
}
