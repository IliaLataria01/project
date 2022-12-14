package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.test.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest implements IAbstractTest {

    // P0 Tested and Works
    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.getTopBarMenu().openLoginPage();
        Assert.assertTrue(loginPage.isLoginFormPresent(),"Login Form was not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(),"UserName Field was not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(),"Password Field was not present.");
        Assert.assertTrue(loginPage.isLoginButtonPresent(),"Log in button was not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_name"),R.TESTDATA.get("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getTopBarMenu().isLogOutButtonPresent(),"Log out button was not present.");
    }

    // P1
//    @Test
//    public void additionOfProductInTheCartTest() {
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        ProductPage productPage = homePage.getProductComponent().clickProduct("Nexus 6");
//        Assert.assertTrue(productPage.isPageOpened(),"Is not opened.");
//    }
//
//    // P2
//    @Test
//    public void RemovalFromCartTest() {
//
//    }
//
    //P3  Tested and Works
    @Test
    public void contactTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ContactPage contactPage = homePage.getTopBarMenu().openContactPage();
        Assert.assertTrue(contactPage.isPageOpened(),"Contact page is not opened.");
        Assert.assertTrue(contactPage.isContactNameFieldPresent(),"Name Field is not present.");
        Assert.assertTrue(contactPage.isEmailFieldPresent(),"Email Field is not present.");
        Assert.assertTrue(contactPage.isMessageAreaPresent(), "Message Area is not present.");
        contactPage.newMessage(R.TESTDATA.get("email"),R.TESTDATA.get("contact_name"),R.TESTDATA.get("message"));
        Assert.assertTrue(contactPage.isSendMessageButtonPresent(),"Send Message Button is not present");
        contactPage.clickSendMessageButton();
        Assert.assertTrue(contactPage.isPageOpened(),"Contact Page is closed.");
    }
//
    // P4 tested and works
    @Test
    public void checkLogOut() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        LoginPage loginPage = homePage.getTopBarMenu().openLoginPage();
        Assert.assertTrue(loginPage.isLoginFormPresent(),"Login Form was not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(),"UserName Field was not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(),"Password Field was not present.");
        Assert.assertTrue(loginPage.isLoginButtonPresent(),"Log in button was not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_name"),R.TESTDATA.get("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getTopBarMenu().isLogOutButtonPresent(),"Log out button was not present.");
        homePage.getTopBarMenu().clickLogOutButton();
        Assert.assertFalse(homePage.getTopBarMenu().isLogOutButtonPresent(),"Log out Button is still present.");


    }
}
