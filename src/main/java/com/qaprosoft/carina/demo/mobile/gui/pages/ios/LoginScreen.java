package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(LoginScreen.class);


    @FindBy(xpath = "name = 'test-Username'")
    @Predicate
    private ExtendedWebElement userNameField;


    @FindBy(xpath = "name = 'test-Password'")
    @Predicate
    private ExtendedWebElement passwordField;


    @FindBy(xpath = "label == 'LOGIN' AND name == 'test-LOGIN'")
    @Predicate
    private ExtendedWebElement loginButton;

    public LoginScreen(WebDriver driver) {
        super(driver);
    }


    public boolean isUserNameFieldPresent() {
        return userNameField.isElementPresent();
    }

    public boolean isPasswordFieldPresent() {
        return passwordField.isElementPresent();
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }

    @Override
    public CatalogScreenBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }


    @Override
    public void typeUserName(String userName) {
        userNameField.type(userName);
    }


    @Override
    public void typePassword(String password) {
        passwordField.type(password);
    }
}
