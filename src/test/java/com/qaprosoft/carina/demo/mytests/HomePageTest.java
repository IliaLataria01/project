package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.test.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest implements IAbstractTest {

    // P0
    @Test
    public void checkLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isLoginButtonPresent(),"Login Button is not present.");
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginFormPresent(),"Login Form is not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(),"PasswordField is not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(),"UserName field is not present.");
        loginPage.inputUserNameAndPassword("Ilia Lataria","Cosmos01");
        Assert.assertTrue(loginPage.isLoginButtonPresent(),"Form Login Button is not present.");
        loginPage.clickLoginButton();
    }

    // P1
    @Test
    public void additionOfProductInTheCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductPage productPage = homePage.clickProduct("Samsung galaxy s7");
        productPage.clickAddToCartButton();
        Assert.assertTrue(productPage.isAddToCartButtonPresent(),"Add to cart button is not present.");
        CartPage cartPage = productPage.clickCartButton();
        Assert.assertTrue(productPage.isCartButtonPresent(),"Cart Button is not present.");
        Assert.assertFalse(cartPage.isCartEmpty(),"Cart is Empty.");
    }

    // P2 Not Complete
    @Test
    public void checkRemovalFromCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductPage productPage = homePage.clickProduct("Sony xperia z5");
        productPage.clickAddToCartButton();
        Assert.assertTrue(productPage.isAddToCartButtonPresent(),"Add to cart button is not present.");
        CartPage cartPage = productPage.clickCartButton();
        Assert.assertTrue(productPage.isCartButtonPresent(),"Cart Button is not present.");
        Assert.assertFalse(cartPage.isCartEmpty(),"Cart is Empty.");

        // Now Only thing that is left is to add remove function that takes same product name
        cartPage.removeProductFromCart("Sony xperia z5");
        cartPage.removeProductFromCart("asdasd");
    }

    //P3
    @Test
    public void checkContact() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ContactPage contactPage = homePage.clickContactButton();
        Assert.assertTrue(homePage.isContactButtonPresent(),"Contact Button is not present.");
        contactPage.newMessage("Ilia@Solvd.com","Ilia Lataria","Hello :)");
        Assert.assertTrue(contactPage.isEmailFieldPresent(),"Mail field is not present.");
        Assert.assertTrue(contactPage.isContactNameFieldPresent(),"Contact name field is not present.");
        Assert.assertTrue(contactPage.isMessageAreaPresent(),"Message area is not present.");
        Assert.assertTrue(contactPage.isSendMessageButtonPresent(),"Send message button is not present.");
        contactPage.clickSendMessageButton();
    }

    // P4 (Since I have tried many names,input is valid for Only Unique userNames)
    @Test
    public void checkLogOut() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        // First We Have to sign Up
        SignUpPage signUpPage = homePage.clickSignUpButton();
        signUpPage.inputSignUp("Pickachu201212323","Cosmos01");
        signUpPage.clickFormSignUpButton();
        Assert.assertTrue(homePage.isSignUpButtonPresent(),"Sign Up button is not present.");
        Assert.assertTrue(signUpPage.isSignUpUserNameFieldPresent(),"Sign up userName field not present.");
        Assert.assertTrue(signUpPage.isSignUpPasswordFieldPresent(),"Sign up password field not present.");
        Assert.assertTrue(signUpPage.isSignUpButtonPresent(),"Form Sign up button not present.");

        // Second We have to log in
        Assert.assertTrue(homePage.isLoginButtonPresent(),"Login Button is not present.");
        LoginPage loginPage = homePage.clickLoginButton();
        Assert.assertTrue(loginPage.isLoginFormPresent(),"Login Form is not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(),"PasswordField is not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(),"UserName field is not present.");
        loginPage.inputUserNameAndPassword("Pickachu201212323","Cosmos01");
        Assert.assertTrue(loginPage.isLoginButtonPresent(),"Form Login Button is not present.");
        loginPage.clickLoginButton();

        // Lastly We Log Out
        Assert.assertTrue(homePage.isLogOutButtonPresent(),"Log out Button is not present.");
        homePage.clickLogOutButton();
    }
}
