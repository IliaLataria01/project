package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.RandomScreenBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = RandomScreenBase.class)
public class RandomScreen extends RandomScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeLink[`label == \"YouTube\"`]")
    private ExtendedWebElement logo;

    public RandomScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }
}
