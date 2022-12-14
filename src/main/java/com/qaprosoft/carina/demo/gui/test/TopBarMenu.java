package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu  extends AbstractUIObject {
    @FindBy(linkText = "Contact")
    private ExtendedWebElement contactLink;

    @FindBy(linkText = "Cart")
    private ExtendedWebElement cartLink;

    @FindBy(linkText = "Log in")
    private ExtendedWebElement logInLink;

    @FindBy(linkText = "Sign up")
    private ExtendedWebElement signUpLink;


    @FindBy(linkText = "Log out")
    private ExtendedWebElement logOutLink;

    public TopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLogOutButtonPresent() {
        return logOutLink.isElementPresent();
    }

    public boolean isLoginButtonPresent() {return logInLink.isElementPresent();}

    public boolean isSignUpButtonPresent() {return signUpLink.isElementPresent();}

    public boolean isCartButtonPresent() {return cartLink.isElementPresent();}

    public boolean isContactButtonPresent() {return contactLink.isElementPresent();}
    public ContactPage openContactPage() {
        contactLink.click();
        return new ContactPage(driver);
    }

    public CartPage openCartPage() {
        cartLink.click();
        return new CartPage(driver);
    }

    public LoginPage openLoginPage() {
        logInLink.click();
        return new LoginPage(driver);
    }

    public SignUpPage openSignUpPage() {
        signUpLink.click();
        return new SignUpPage(driver);
    }

    public void clickLogOutButton() {
        logOutLink.click();
    }
}
