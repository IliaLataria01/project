package com.qaprosoft.carina.demo.gui.test.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.test.CartPage;
import com.qaprosoft.carina.demo.gui.test.ContactPage;
import com.qaprosoft.carina.demo.gui.test.LoginPage;
import com.qaprosoft.carina.demo.gui.test.SignUpPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu  extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(TopBarMenu.class);
    @FindBy(xpath = "//*[@id=\"login2\"]")
    private ExtendedWebElement contactLink;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    private ExtendedWebElement cartLink;

    @FindBy(xpath = "//*[@id=\"login2\"]")
    private ExtendedWebElement logInLink;

    @FindBy(xpath = "//*[@id=\"signin2\"]")
    private ExtendedWebElement signUpLink;


    @FindBy(xpath = "//*[@id=\"logout2\"]")
    private ExtendedWebElement logOutLink;

    public TopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver,searchContext);
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
