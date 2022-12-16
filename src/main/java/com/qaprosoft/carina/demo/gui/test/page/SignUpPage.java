package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SignUpPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class);

    @FindBy(xpath = "//div[@id='signInModal']//div[@class='modal-content']")
    private ExtendedWebElement signUpForm;

    @FindBy(id = "sign-username")
    private ExtendedWebElement signUserInput;

    @FindBy(id = "sign-password")
    private ExtendedWebElement signPasswordInput;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    private ExtendedWebElement signUpButton;

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

    public List<String> inputSignUp(String userName, String password) {
        signUserInput.type(userName);
        signPasswordInput.type(password);
        return Arrays.asList(userName, password);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
