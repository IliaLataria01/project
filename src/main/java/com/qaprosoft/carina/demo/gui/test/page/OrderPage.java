package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(OrderPage.class);

    @FindBy(xpath = "\"//div[@id='orderModal']//div[@class='modal-content']\"")
    private ExtendedWebElement orderForm;

    @FindBy(id = "name")
    private ExtendedWebElement nameField;

    @FindBy(id = "country")
    private ExtendedWebElement countryField;

    @FindBy(id = "city")
    private ExtendedWebElement cityField;

    @FindBy(id = "card")
    private ExtendedWebElement cardField;

    @FindBy(id = "month")
    private ExtendedWebElement monthField;

    @FindBy(id = "year")
    private ExtendedWebElement yearField;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    private ExtendedWebElement purchaseButton;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void fillTheForm(String name, String country, String city, String creditCard, String month, String year) {
        assertElementPresent(nameField);
        nameField.type(name);
        assertElementPresent(countryField);
        countryField.type(country);
        assertElementPresent(cityField);
        cityField.type(city);
        assertElementPresent(cardField);
        cardField.type(creditCard);
        assertElementPresent(monthField);
        monthField.type(month);
        assertElementPresent(yearField);
        yearField.type(year);
    }

    public ConfirmationPage clickPurchaseButton() {
        assertElementPresent(purchaseButton);
        purchaseButton.click();
        return new ConfirmationPage(driver);
    }
}
