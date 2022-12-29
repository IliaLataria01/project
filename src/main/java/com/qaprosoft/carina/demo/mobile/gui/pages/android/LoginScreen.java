package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(LoginScreen.class);

    @FindBy(xpath = "//*[@content-desc='test-Username']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//*[@content-desc='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@content-desc='test-LOGIN']")
    private ExtendedWebElement loginButton;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CatalogScreenBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }

    @Override
    public boolean isUserNameFieldPresent() {
        return userNameField.isElementPresent();
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordField.isElementPresent();
    }

    @Override
    public void typeUserName(String userName) {
        userNameField.type(userName);
    }

    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }

    @Override
    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }
}
