package com.qaprosoft.carina.demo.mobile.gui.pages.modals;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationScreenBase;
import org.openqa.selenium.WebDriver;

public abstract class LocationPermissionsAlertBase extends AbstractPage {
    public LocationPermissionsAlertBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAllowButtonPresent();

    public abstract LocationScreenBase clickAllowButton();
}
