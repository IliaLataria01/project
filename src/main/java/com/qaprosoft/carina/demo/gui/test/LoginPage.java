package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div")
    private ExtendedWebElement loginForm;

    @FindBy(id = "loginusername")
    private ExtendedWebElement loginUserNameInput;

    @FindBy(id = "loginpassword")
    private ExtendedWebElement loginPasswordInput;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginFormPresent() {
        return loginForm.isElementPresent();
    }

    public boolean isLoginUserNameFieldPresent() {
        return loginUserNameInput.isElementPresent();
    }

    public boolean isLoginPasswordFieldPresent() {
        return loginPasswordInput.isElementPresent();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }


    public void inputUserNameAndPassword(String userName,String password) {
        loginUserNameInput.type(userName);
        loginPasswordInput.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
