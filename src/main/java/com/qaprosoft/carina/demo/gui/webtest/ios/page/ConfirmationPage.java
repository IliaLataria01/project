package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends AbstractPage {
    private final static Logger LOGGER = LogManager.getLogger(ConfirmationPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private ExtendedWebElement confirmButton;


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isConfirmButtonPresent() {
        return confirmButton.isElementPresent();
    }

    public void clickConfirmButton() {
        confirmButton.click();
    }

}