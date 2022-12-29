package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MenuAboutScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.enums.AboutMenuOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuAboutScreenBase.class)
public class MenuAboutScreen extends MenuAboutScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(MenuAboutScreen.class);


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == '%s'`][1]")
    private ExtendedWebElement menuOption;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Menu\"`]")
    private ExtendedWebElement closeButton;

    public MenuAboutScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMenuOptionPresent(AboutMenuOptions aboutMenuOption) {
        return menuOption.format(aboutMenuOption.getOption()).isElementPresent();
    }

    @Override
    public boolean isCloseButtonPresent() {
        return closeButton.isElementPresent();
    }

    @Override
    public void clickCloseButton() {
        closeButton.click();
    }
}
