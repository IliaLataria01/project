package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LocationScreenBase extends AbstractPage {
    public LocationScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAllowButtonPresent();

    public abstract void clickAllowButton();

    public abstract boolean isLocationBarPresent();
}
