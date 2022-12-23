package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.modals.LocationPermissionsAlertBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LocationPermissionsAlertBase.class)
public class LocationPermissionsAlert extends LocationPermissionsAlertBase {
    private static final Logger LOGGER = LogManager.getLogger(LocationPermissionsAlert.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Allow Once\"`]")
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
        return initPage(getDriver(), LocationScreenBase.class);
    }
}
