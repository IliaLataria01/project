package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.test.*;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest implements IAbstractTest {

    // P0 Works
    @Test
    public void LoginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.getTopBarMenu().openLoginPage();
        Assert.assertTrue(loginPage.isLoginFormPresent(),"Login Form was not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(),"UserName Field was not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(),"Password Field was not present.");
        Assert.assertTrue(loginPage.isLoginButtonPresent(),"Log in button was not present.");
        loginPage.inputLogin("Ilia123","Ilia2002");
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getTopBarMenu().isLogOutButtonPresent(),"Log out button was not present.");
    }

    // P1
    @Test
    public void additionOfProductInTheCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductPage productPage = homePage.getProductComponent().clickProduct("Nexus 6");
        Assert.assertTrue(productPage.isPageOpened(),"Is not opened.");
    }

    // P2
    @Test
    public void RemovalFromCartTest() {

    }

    //P3 Works
    @Test
    public void ContactTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ContactPage contactPage = homePage.getTopBarMenu().openContactPage();
        Assert.assertTrue(contactPage.isPageOpened(),"Contact page is not opened.");
        Assert.assertTrue(contactPage.isContactNameFieldPresent(),"Name Field is not present.");
        Assert.assertTrue(contactPage.isEmailFieldPresent(),"Email Field is not present.");
        Assert.assertTrue(contactPage.isMessageAreaPresent(), "Message Area is not present.");
        contactPage.newMessage("Ilia@solvd.com","Ilia Laataria","hello");
        Assert.assertTrue(contactPage.isSendMessageButtonPresent(),"Send Message Button is not present");
        contactPage.clickSendMessageButton();
        Assert.assertTrue(contactPage.isPageOpened(),"Contact Page is closed.");
    }

    // P4
    @Test
    public void checkLogOut() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        // First We Have to sign Up
        SignUpPage signUpPage = homePage.getTopBarMenu().openSignUpPage();
        List<String> userInfo = signUpPage.inputSignUp();
        homePage = signUpPage.clickSignUpButton();

        Assert.assertTrue(homePage.isPageOpened(),"Home page is not opened");

        LoginPage loginPage = homePage.getTopBarMenu().openLoginPage();
        Assert.assertTrue(loginPage.isLoginFormPresent(),"Login Form is not present.");



//
//        Assert.assertTrue(homePage.getTopBarMenu().isLogOutButtonPresent(),"Log out button was not present.");
//        homePage.getTopBarMenu().clickLogOutButton();
//        Assert.assertTrue(homePage.getTopBarMenu().isLoginButtonPresent(),"Log in button is not present.");
//        Assert.assertTrue(homePage.getTopBarMenu().isSignUpButtonPresent(),"Sign up button is not present.");

    }
}
