package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ConfirmScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutScreenBase.class)
public class CheckoutScreen extends CheckoutScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(CheckoutScreen.class);


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-First Name\"`]")
    private ExtendedWebElement firstNameField;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-Last Name\"`]")
    private ExtendedWebElement lastNameField;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == \"test-Zip/Postal Code\"`]")
    private ExtendedWebElement postalCodeField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"CONTINUE\"`][1]")
    private ExtendedWebElement continueButton;


    public CheckoutScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFirstNameFieldPresent() {
        return firstNameField.isElementPresent();
    }

    @Override
    public boolean isLastNameFieldPresent() {
        return lastNameField.isElementPresent();
    }

    @Override
    public boolean isPostalCodeFieldPresent() {
        return postalCodeField.isElementPresent();
    }

    @Override
    public void typeFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    @Override
    public void typeLastName(String lastName) {
        lastNameField.type(lastName);
    }

    @Override
    public void typePostalCode(String postalCode) {
        postalCodeField.type(postalCode);
    }

    @Override
    public ConfirmScreenBase clickContinueButton() {
        continueButton.click();
        return initPage(getDriver(), ConfirmScreenBase.class);
    }

    @Override
    public boolean isContinueButtonPresent() {
        return continueButton.isElementPresent();
    }


}
