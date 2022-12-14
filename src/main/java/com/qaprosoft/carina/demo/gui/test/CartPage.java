package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);


    @FindBy(xpath = "//*[@class=\"success\"]")
    private List<ExtendedWebElement> listed_products;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr")
    private ExtendedWebElement checkCartEmpty;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartEmpty() {
        return !checkCartEmpty.isElementPresent();
    }

    public void removeProductFromCart(String product) {
        // Since I only add one product,going to get first out of list
        listed_products.get(0).findExtendedWebElement(By.tagName("a")).click();
    }
}
