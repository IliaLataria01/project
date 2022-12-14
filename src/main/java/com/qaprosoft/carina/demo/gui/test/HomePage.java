package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.Console;
import java.util.List;
import java.util.Objects;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(id = "login2")
    private ExtendedWebElement loginBtn;

    @FindBy(id = "signin2")
    private ExtendedWebElement signUpButton;

    @FindBy(id = "logout2")
    private ExtendedWebElement logOutButton;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    private ExtendedWebElement contactButton;

    @FindBy(xpath = "//*[@class=\"col-lg-4 col-md-6 mb-4\"]")
    private List<ExtendedWebElement> productList;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean isLoginButtonPresent() {
        return loginBtn.isElementPresent();
    }


    public boolean isSignUpButtonPresent() {return signUpButton.isElementPresent();}


    public boolean isLogOutButtonPresent() {return logOutButton.isElementPresent();}

    public boolean isContactButtonPresent() {return contactButton.isElementPresent();}

    public ProductPage clickProduct(String product) {
        for (ExtendedWebElement element : productList) {
            String text = element.findExtendedWebElement(By.className("card-title")).getText();
            if (product.equalsIgnoreCase(text)) {
                element.click();
                return new ProductPage(driver);
            }
        }
        throw new IllegalArgumentException("Product not available right now or maybe name of the indicated product is invalid");
    }


    public void clickLogOutButton() {
        logOutButton.click();
    }

    public LoginPage clickLoginButton() {
        loginBtn.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public ContactPage clickContactButton() {
        contactButton.click();
        return new ContactPage(driver);
    }

}
