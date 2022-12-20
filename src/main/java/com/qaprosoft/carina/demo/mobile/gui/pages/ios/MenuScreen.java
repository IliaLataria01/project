package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
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
    public LoginScreenBase clickLogOutButton() {
        menuOption.format(MenuOptions.LOGOUT.getOption()).click();
        return initPage(getDriver(), LoginScreenBase.class);
    }

    @Override
    public WebViewScreenBase clickWebViewButton() {
        menuOption.format(MenuOptions.WEBVIEW.getOption()).click();
        return initPage(getDriver(),WebViewScreenBase.class);
    }

    @Override
    public DrawScreenBase clickDrawingButton() {
        menuOption.format(MenuOptions.DRAWING.getOption()).click();
        return initPage(getDriver(), DrawScreenBase.class);
    }

    @Override
    public CatalogScreenBase clickAllItemsButton() {
        menuOption.format(MenuOptions.ALLITEMS.getOption()).click();
        return initPage(getDriver(),CatalogScreenBase.class);
    }

    @Override
    public LocationScreenBase clickLocationButton() {
        menuOption.format(MenuOptions.GEOLOCATION.getOption()).click();
        return initPage(getDriver(), LocationScreenBase.class);
    }


}
