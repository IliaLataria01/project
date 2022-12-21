package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.MenuOptions;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuScreenBase.class)
public class MenuScreen extends MenuScreenBase {

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
    public boolean checkMenuOption(MenuOptions option) {
        return menuOption.format(option.getOption()).isElementPresent();
    }

    @Override
    public AbstractPage clickMenuOption(MenuOptions option) {
        menuOption.format(option.getOption()).click();
        return initPage(getDriver(), option.getaClass());
    }


}
