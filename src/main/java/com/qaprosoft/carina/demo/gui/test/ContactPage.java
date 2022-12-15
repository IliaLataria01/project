package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.test.components.MenuComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(ContactPage.class);

    @FindBy(id = "navbarExample")
    private MenuComponent topBarMenu;

    @FindBy(id = "recipient-email")
    private ExtendedWebElement emailField;

    @FindBy(id = "recipient-name")
    private ExtendedWebElement contactNameField;

    @FindBy(id = "message-text")
    private ExtendedWebElement messageArea;

    @FindBy(xpath = "//button[contains(text(),'Send message')]")
    private ExtendedWebElement sendMessageButton;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldPresent() {
        return emailField.isElementPresent();
    }

    public boolean isContactNameFieldPresent() {
        return contactNameField.isElementPresent();
    }

    public boolean isMessageAreaPresent() {
        return messageArea.isElementPresent();
    }

    public boolean isSendMessageButtonPresent() {
        return sendMessageButton.isElementPresent();
    }

    public void newMessage(String email,String contactName,String message) {
        emailField.type(email);
        contactNameField.type(contactName);
        messageArea.type(message);
    }

    public MenuComponent getTopBarMenu() {
        return topBarMenu;
    }

    public void clickSendMessageButton() {
        sendMessageButton.click();
    }
}
