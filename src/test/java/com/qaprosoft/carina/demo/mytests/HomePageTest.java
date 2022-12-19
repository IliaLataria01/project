package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.test.components.Category;
import com.qaprosoft.carina.demo.gui.test.components.CategoryComponent;
import com.qaprosoft.carina.demo.gui.test.page.*;
import com.qaprosoft.carina.demo.gui.test.util.UserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest implements IAbstractTest {

    // P0 Tested and Works
    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.getMenuComponent().openLoginPage();
        Assert.assertTrue(loginPage.isLoginFormPresent(), "Login Form was not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(), "UserName Field was not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(), "Password Field was not present.");
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Log in button was not present.");
        // This test one for already Registered
        loginPage.inputLogin(R.TESTDATA.get("user_name"), R.TESTDATA.get("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getMenuComponent().isWelcomeMessagePresent(R.TESTDATA.get("user_name")), "" +
                "Appropriate welcome message is not present.");
    }



    //P3  Tested and Works
    @Test
    public void contactTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ContactPage contactPage = homePage.getMenuComponent().openContactPage();
        Assert.assertTrue(contactPage.isPageOpened(), "Contact page is not opened.");
        Assert.assertTrue(contactPage.isContactNameFieldPresent(), "Name Field is not present.");
        Assert.assertTrue(contactPage.isEmailFieldPresent(), "Email Field is not present.");
        Assert.assertTrue(contactPage.isMessageAreaPresent(), "Message Area is not present.");
        contactPage.newMessage(R.TESTDATA.get("email"), R.TESTDATA.get("contact_name"), R.TESTDATA.get("message"));
        Assert.assertTrue(contactPage.isSendMessageButtonPresent(), "Send Message Button is not present");
        contactPage.clickSendMessageButton();
        Assert.assertTrue(homePage.isNextPageButtonPresent(), "NextPage button is not present.");
    }

    //
    // P4 tested and works
    @Test
    public void checkLogOut() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.getMenuComponent().openLoginPage();
        Assert.assertTrue(loginPage.isLoginFormPresent(), "Login Form was not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(), "UserName Field was not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(), "Password Field was not present.");
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Log in button was not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_name"), R.TESTDATA.get("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getMenuComponent().isLogOutButtonPresent(), "Log out button was not present.");
        homePage.getMenuComponent().clickLogOutButton();
        Assert.assertFalse(homePage.getMenuComponent().isLogOutButtonPresent(), "Log out Button is still present.");
    }


    @Test
    public void signUpTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SignUpPage signUpPage = homePage.getMenuComponent().openSignUpPage();
        Assert.assertTrue(signUpPage.isSignUpFormPresent(), "Sign up form was not present.");
        Assert.assertTrue(signUpPage.isSignUpUserNameFieldPresent(), "UserName field was not present.");
        Assert.assertTrue(signUpPage.isSignUpPasswordFieldPresent(), "Password field was not present.");
        signUpPage.inputSignUp(UserFactory.getRandomUserName(), UserFactory.getRandomPassword());
        signUpPage.clickSignUpButton();
        Assert.assertTrue(homePage.getMenuComponent().isSignUpButtonPresent(), "Sign up button was not present.");
        Assert.assertTrue(homePage.getMenuComponent().isLoginButtonPresent(), "Login button was not present.");
    }

    @Test
    public void categoryTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CategoryComponent categoryComponent = homePage.getCategoryComponent();
        categoryComponent.switchCategory(Category.MONITORS);
        Assert.assertTrue(categoryComponent.isProductContainerPresent(), "Product Container is not present.");
        Assert.assertTrue(categoryComponent.checkProducts(), "products size is < 1");
        categoryComponent.switchCategory(Category.PHONES);
        Assert.assertTrue(categoryComponent.isProductContainerPresent(), "Product Container is not present.");
        Assert.assertTrue(categoryComponent.checkProducts(), "products size is < 1");
        categoryComponent.switchCategory(Category.LAPTOPS);
        Assert.assertTrue(categoryComponent.isProductContainerPresent(), "Product Container is not present.");
        Assert.assertTrue(categoryComponent.checkProducts(), "products size is < 1");
    }

    @Test
    public void aboutTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        AboutPage aboutPage = homePage.getMenuComponent().openAboutPage();
        Assert.assertTrue(aboutPage.isVideoPresent(), "Video is not present");
        aboutPage.playVideo(10000); // Let's say 10 seconds
        Assert.assertTrue(aboutPage.isCloseButtonPresent(), "Close button is not present");
        aboutPage.clickCloseButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }


    @Test
    public void carouselTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(homePage.getCarouselComponent().isNextButtonPresent(), "Next Page button is not present");
            Assert.assertTrue(
                    homePage.getCarouselComponent().isProductPresent(homePage.getCarouselComponent().getCount()),
                    "Product is not present");
            homePage.getCarouselComponent().clickRight();
        }
        Assert.assertTrue(homePage.isPageOpened(), "Home Page is not opened.");
    }
}
