package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//div[@id='logInModal']//div[@class='modal-content']")
    private ExtendedWebElement loginForm;

    @FindBy(id = "loginusername")
    private ExtendedWebElement loginUserNameInput;

    @FindBy(id = "loginpassword")
    private ExtendedWebElement loginPasswordInput;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
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

    public void inputLogin(String userName,String password) {
        loginUserNameInput.type(userName);
        loginPasswordInput.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
