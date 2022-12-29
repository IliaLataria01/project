package com.qaprosoft.carina.demo.gui.webtest.ios.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.webtest.common.enums.NavigationLinks;
import com.qaprosoft.carina.demo.gui.webtest.ios.page.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class MenuComponent extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(MenuComponent.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == '%s'`]")
    private ExtendedWebElement navLink;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == '%s'`]")
    private ExtendedWebElement welcomeMessage;

    public MenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLinkPresent(NavigationLinks link) {
        return navLink.format(link.getLink()).isElementPresent();
    }

    public AbstractPage openPage(NavigationLinks link) {
        if (link.getLink().equals("Contact")) {
            navLink.format(link.getLink()).click();
            return new ContactPage(driver);
        }
        if (link.getLink().equals("About us")) {
            navLink.format(link.getLink()).click();
            return new AboutPage(driver);
        }
        if (link.getLink().equals("Cart")) {
            navLink.format(link.getLink()).click();
            return new CartPage(driver);
        }
        if (link.getLink().equals("Log in")) {
            navLink.format(link.getLink()).click();
            return new LoginPage(driver);
        }
        if (link.getLink().equals("Sign up")) {
            navLink.format(link.getLink()).click();
            return new SignUpPage(driver);
        }
        return null;
    }

    public void clickLogOutButton() {
        navLink.format(NavigationLinks.LOGOUT.getLink()).click();
    }

    public boolean isWelcomeMessagePresent(String userName) {
        return welcomeMessage.format("Welcome " + userName).isElementPresent();
    }
}
