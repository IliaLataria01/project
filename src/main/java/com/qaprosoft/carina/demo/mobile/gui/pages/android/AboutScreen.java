package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.AboutScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MenuAboutScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SafariBrowserBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutScreenBase.class)
public class AboutScreen extends AboutScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(AboutScreen.class);


    @FindBy(xpath = "//*[@content-desc='Home']")
    private ExtendedWebElement homeButton;

    @FindBy(xpath = "//*[@content-desc='Menu']")
    private ExtendedWebElement menuButton;

    public AboutScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isHomeButtonPresent() {
        return homeButton.isElementPresent();
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
