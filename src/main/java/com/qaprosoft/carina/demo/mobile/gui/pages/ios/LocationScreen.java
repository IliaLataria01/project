package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LocationScreenBase.class)

public class LocationScreen extends LocationScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(LocationScreen.class);


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Allow Once\"`]")
    private ExtendedWebElement allowButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"GEO LOCATION\"`]")
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
