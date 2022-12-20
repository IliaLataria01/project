package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginScreenBase extends AbstractPage {

    public LoginScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract CatalogScreenBase clickLoginButton();

    public abstract boolean isUserNameFieldPresent();

    public abstract boolean isPasswordFieldPresent();

    public abstract void typeUserName(String userName);

    public abstract void typePassword(String password);

    public abstract boolean isLoginButtonPresent();
}
