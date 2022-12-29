package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.*;

public class SignUpPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]")
    private ExtendedWebElement signUpForm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField")
    private ExtendedWebElement signUserInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeSecureTextField")
    private ExtendedWebElement signPasswordInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Sign up\"`]")
    private ExtendedWebElement signUpButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Close\"`]")
    private ExtendedWebElement closeButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpFormPresent() {
        return signUpForm.isElementPresent();
    }

    public boolean isSignUpUserNameFieldPresent() {
        return signUserInput.isElementPresent();
    }

    public boolean isSignUpPasswordFieldPresent() {
        return signPasswordInput.isElementPresent();
    }

    public boolean isSignUpButtonPresent() {
        return signUpButton.isElementPresent();
    }

    public boolean isCloseButtonPresent() {
        return closeButton.isElementPresent();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public List<String> inputSignUp(String userName, String password) {
        signUserInput.type(userName);
        signPasswordInput.type(password);
        return Arrays.asList(userName, password);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
