package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;


public class AboutPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(AboutPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Play Video\"`]")
    private ExtendedWebElement video;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Close\"`][2]")
    private ExtendedWebElement closeButton;


    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVideoPresent() {
        return video.isElementPresent();
    }

    public boolean isCloseButtonPresent() {
        return closeButton.isElementPresent();
    }

    public void playVideo() {
        video.click();
    }

    public void clickCloseButton() {
        closeButton.click();
    }
}
