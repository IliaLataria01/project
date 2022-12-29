package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]")
    private ExtendedWebElement loginForm;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"document\"`]/XCUIElementTypeTextField")
    private ExtendedWebElement loginUserNameInput;

    @ExtendedFindBy(iosPredicate = "type == \"XCUIElementTypeSecureTextField\"")
    private ExtendedWebElement loginPasswordInput;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Log in\"`]")
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

    public void inputLogin(String userName, String password) {
        loginUserNameInput.type(userName);
        loginPasswordInput.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}