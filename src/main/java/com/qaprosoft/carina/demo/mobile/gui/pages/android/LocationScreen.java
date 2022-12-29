package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LocationScreenBase.class)
public class LocationScreen extends LocationScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(LocationScreen.class);

    @FindBy(xpath = "//*[@text='Only this time']")
    private ExtendedWebElement allowButton;

    @FindBy(xpath = "//*[@text='GEO LOCATION']")
    private ExtendedWebElement locationBar;

    public LocationScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAllowButtonPresent() {
        return allowButton.isElementPresent();
    }

    @Override
    public void clickAllowButton() {
        allowButton.click();
    }

    @Override
    public boolean isLocationBarPresent() {
        return locationBar.isElementPresent();
    }
}
