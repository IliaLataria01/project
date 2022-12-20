package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DrawScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LocationScreenBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LocationScreenBase.class)

public class LocationScreen extends LocationScreenBase {

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
