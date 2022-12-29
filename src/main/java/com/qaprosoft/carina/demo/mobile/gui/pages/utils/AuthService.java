package com.qaprosoft.carina.demo.mobile.gui.pages.utils;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginScreenBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;

public class AuthService implements IAbstractTest {

    public CatalogScreenBase login() {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        Assert.assertTrue(loginPage.isUserNameFieldPresent(), "UserName field is not present.");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present.");
        loginPage.typeUserName(R.TESTDATA.get("user_first"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button is not present.");
        CatalogScreenBase welcomeScreen = loginPage.clickLoginButton();
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");
        return welcomeScreen;
    }
}
