package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.test.components.MenuComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    @FindBy(id = "navbarExample")
    private MenuComponent topBarMenu;

    @FindBy(xpath = "//*[@class=\"success\"]//a")
    private ExtendedWebElement product;


    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(product);
    }

    public MenuComponent getTopBarMenu() {
        return topBarMenu;
    }


    public void removeProductFromCart() {
        // Since I only add one product,going to get first out of list
        assertElementPresent(product);
        product.click();
    }
}
