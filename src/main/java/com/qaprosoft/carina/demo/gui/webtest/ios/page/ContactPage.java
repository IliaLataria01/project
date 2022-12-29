package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ContactPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(ContactPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[1]")
    private ExtendedWebElement emailField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[2]")
    private ExtendedWebElement contactNameField;

    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeTextView\"")
    private ExtendedWebElement messageArea;

    @ExtendedFindBy(iosPredicate = "label == \"Send message\"")
    private ExtendedWebElement sendMessageButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Close\"`]")
    private ExtendedWebElement closeButton;

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

    public boolean isCloseButtonPresent() {
        return closeButton.isElementPresent();
    }

    public void newMessage(String email, String contactName, String message) {
        emailField.type(email);
        contactNameField.type(contactName);
        messageArea.type(message);
    }

    public void clickCloseButton() {
        closeButton.click();
    }


    public void clickSendMessageButton() {
        sendMessageButton.click();
    }
}
