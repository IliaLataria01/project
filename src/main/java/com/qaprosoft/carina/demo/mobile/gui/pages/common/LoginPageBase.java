package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WelcomePageBase clickLoginButton();

    public abstract boolean isUserNameFieldPresent();

    public abstract boolean isPasswordFieldPresent();

    public abstract void inputLogin(String userName);

    public abstract boolean isLoginButtonPresent();
}
