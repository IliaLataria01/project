package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.MenuOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuScreenBase.class)
public class MenuScreen extends MenuScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(MenuScreen.class);


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Close\"`]")
    private ExtendedWebElement closeButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == '%s'`]")
    private ExtendedWebElement menuOption;

    public MenuScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickCloseButton() {
        closeButton.click();
    }

    @Override
    public boolean isCloseButtonPresent() {
        return closeButton.isElementPresent();
    }

    @Override
    public boolean checkMenuOption(MenuOption option) {
        return menuOption.format(option.getOption()).isElementPresent();
    }

    @Override
    public AbstractPage clickMenuOption(MenuOption option) {
        menuOption.format(option.getOption()).click();
        return initPage(getDriver(), option.getaClass());
    }


}
