package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class);
    @FindBy(id = "sign-username")
    private ExtendedWebElement signUserInput;

    @FindBy(id = "sign-password")
    private ExtendedWebElement signPasswordInput;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    private ExtendedWebElement signUpButton;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpUserNameFieldPresent() {return signUserInput.isElementPresent();}

    public boolean isSignUpPasswordFieldPresent() {return signPasswordInput.isElementPresent();}

    public boolean isSignUpButtonPresent() {return signUpButton.isElementPresent();}

    public void inputSignUp(String userName,String password) {
        signUserInput.type(userName);
        signPasswordInput.type(password);
    }

    public void clickFormSignUpButton() {
        signUpButton.click();
    }



}
