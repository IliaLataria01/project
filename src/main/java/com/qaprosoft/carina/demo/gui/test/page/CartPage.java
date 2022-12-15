package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.test.components.MenuComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    @FindBy(id = "navbarExample")
    private MenuComponent topBarMenu;

    @FindBy(xpath = "//*[@class='success']//td[contains(text(),'%s')]/parent::tr//a[contains(text(),'Delete')]")
    private ExtendedWebElement product;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public MenuComponent getTopBarMenu() {
        return topBarMenu;
    }

    public boolean isProductPresent() {
        return product.isElementPresent();
    }

    public void removeProductFromCart(String productName) {
        product.format(productName).click();
    }
}
