package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MenuScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.RandomScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewScreenBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewScreenBase.class)
public class WebViewScreen extends WebViewScreenBase {


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-enter a https url here...\"`]")
    private ExtendedWebElement urlField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"GO TO SITE\"`][3]")
    private ExtendedWebElement goToButton;

    public WebViewScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isURLFieldPresent() {
        return urlField.isElementPresent();
    }

    @Override
    public void typeURL(String url) {
        urlField.type(url);
    }

    @Override
    public RandomScreenBase clickGoToSiteButton() {
        goToButton.click();
        return initPage(getDriver(), RandomScreenBase.class);
    }

    @Override
    public boolean isGoToButtonPresent() {
        return goToButton.isElementPresent();
    }
}
