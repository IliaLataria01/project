package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SignUpPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class);

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div")
    private ExtendedWebElement signUpForm;

    @FindBy(id = "sign-username")
    private ExtendedWebElement signUserInput;

    @FindBy(id = "sign-password")
    private ExtendedWebElement signPasswordInput;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    private ExtendedWebElement signUpButton;


    private UserFactory userFactory;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.userFactory = new UserFactory();
    }

    public boolean isSignUpFormPresent() {return signUpForm.isElementPresent();}

    public boolean isSignUpUserNameFieldPresent() {return signUserInput.isElementPresent();}

    public boolean isSignUpPasswordFieldPresent() {return signPasswordInput.isElementPresent();}

    public boolean isSignUpButtonPresent() {return signUpButton.isElementPresent();}

    public List<String> inputSignUp() {
        String userName = userFactory.randomUserName();
        String password = userFactory.randomPassword();
        signUserInput.type(userName);
        signPasswordInput.type(password);
        return Arrays.asList(userName,password);
    }

    public HomePage clickSignUpButton() {
        signUpButton.click();
        return new HomePage(driver);

    }
}
