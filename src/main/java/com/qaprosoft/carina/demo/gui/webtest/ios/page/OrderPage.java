package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class OrderPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(OrderPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]")
    private ExtendedWebElement orderForm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[1]")
    private ExtendedWebElement nameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[2]")
    private ExtendedWebElement countryField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[3]")
    private ExtendedWebElement cityField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[4]")
    private ExtendedWebElement cardField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[5]")
    private ExtendedWebElement monthField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField[6]")
    private ExtendedWebElement yearField;

    @ExtendedFindBy(iosPredicate = "label == \"Purchase\"")
    private ExtendedWebElement purchaseButton;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNameFieldPresent() {
        return nameField.isElementPresent();
    }

    public boolean isCountryFieldPresent() {
        return countryField.isElementPresent();
    }

    public boolean isCityFieldPresent() {
        return cityField.isElementPresent();
    }

    public boolean isCardFieldPresent() {
        return cardField.isElementPresent();
    }

    public boolean isMonthFieldPresent() {
        return monthField.isElementPresent();
    }

    public boolean isYearFieldPresent() {
        return yearField.isElementPresent();
    }

    public void fillTheForm(String name, String country, String city, String creditCard, String month, String year) {
        nameField.type(name);
        countryField.type(country);
        cityField.type(city);
        cardField.type(creditCard);
        monthField.type(month);
        yearField.type(year);
    }

    public boolean isPurchaseButtonPresent() {
        return purchaseButton.isElementPresent();
    }

    public ConfirmationPage clickPurchaseButton() {
        purchaseButton.click();
        return new ConfirmationPage(driver);
    }
}
