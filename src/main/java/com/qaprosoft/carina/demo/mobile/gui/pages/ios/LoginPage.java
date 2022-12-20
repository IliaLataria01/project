package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "name = 'test-Username'")
    @Predicate
    private ExtendedWebElement userNameField;


    @FindBy(xpath = "name = 'test-Password'")
    @Predicate
    private ExtendedWebElement passwordField;


    @FindBy(xpath = "label == 'LOGIN' AND name == 'test-LOGIN'")
    @Predicate
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
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
    public WelcomePageBase clickLoginButton() {
        loginButton.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }

    public void inputLogin(String userName) {
        userNameField.type(userName);
        passwordField.type(R.TESTDATA.get("password"));
    }
}
