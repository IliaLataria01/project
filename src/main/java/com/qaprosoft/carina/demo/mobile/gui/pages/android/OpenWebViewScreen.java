package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WebViewScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.OpenWebViewScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OpenWebViewScreenBase.class)
public class OpenWebViewScreen extends OpenWebViewScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(OpenWebViewScreen.class);

    @FindBy(xpath = "//*[@content-desc='test-enter a https url here...']")
    private ExtendedWebElement urlField;

    @FindBy(xpath = "//*[@content-desc='test-GO TO SITE']")
    private ExtendedWebElement goToButton;

    public OpenWebViewScreen(WebDriver driver) {
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
    public WebViewScreenBase clickGoToSiteButton() {
        goToButton.click();
        return initPage(getDriver(), WebViewScreenBase.class);
    }

    @Override
    public boolean isGoToButtonPresent() {
        return goToButton.isElementPresent();
    }
}
