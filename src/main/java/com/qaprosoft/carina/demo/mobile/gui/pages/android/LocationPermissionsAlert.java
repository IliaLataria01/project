package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationPermissionsAlertBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = LocationPermissionsAlertBase.class)
public class LocationPermissionsAlert extends LocationPermissionsAlertBase {

    private static final Logger LOGGER = LogManager.getLogger(LocationPermissionsAlert.class);

    @FindBy(xpath = "//*[@text='Only this time']")
    private ExtendedWebElement allowButton;

    public LocationPermissionsAlert(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAllowButtonPresent() {
        return allowButton.isElementPresent();
    }

    @Override
    public LocationScreenBase clickAllowButton() {
        allowButton.click();
        return initPage(getDriver(),LocationScreenBase.class);
    }
}
