package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewScreenBase.class)
public class WebViewScreen extends WebViewScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(WebViewScreen.class);


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeLink[`label == \"YouTube\"`]")
    private ExtendedWebElement logo;

    public WebViewScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }
}
