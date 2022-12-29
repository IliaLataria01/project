package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.AboutScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SafariBrowserBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutScreenBase.class)
public class AboutScreen extends AboutScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(AboutScreen.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"navigation\"`]")
    private ExtendedWebElement aboutButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Menu\"`]")
    private ExtendedWebElement menuButton;

    public AboutScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHomeButtonPresent() {
        return aboutButton.isElementPresent();
    }

    @Override
    public boolean isMenuButtonPresent() {
        return menuButton.isElementPresent();
    }

    @Override
    public SafariBrowserBase clickMenuButton() {
        menuButton.click();
        return initPage(getDriver(), SafariBrowserBase.class);
    }
}
