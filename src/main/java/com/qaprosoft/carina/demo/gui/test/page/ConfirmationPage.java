package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractPage {
    private final static Logger LOGGER = LogManager.getLogger(ConfirmationPage.class);

    @FindBy(xpath = "//div[@class='sa-confirm-button-container']")
    private ExtendedWebElement confirmButton;


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void clickConfirmButton() {
        assertElementPresent(confirmButton);
        confirmButton.click();
    }

}
