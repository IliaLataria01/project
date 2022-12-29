package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.webtest.ios.components.MenuComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"navigation\"`]/XCUIElementTypeOther")
    private MenuComponent topBarMenu;

    @ExtendedFindBy(iosPredicate = "**//XCUIElementTypeOther[$type == XCUIElementTypeStaticText AND name == '%s'$][-2]/**/XCUIElementTypeLink[`name == \\\"Delete\\\"`]")
    private ExtendedWebElement product;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Place Order\"`]")
    private ExtendedWebElement orderButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public MenuComponent getTopBarMenu() {
        return topBarMenu;
    }

    public boolean isProductPresent(String productName) {
        return product.isElementPresent();
    }

    public void removeProductFromCart(String productName) {
        product.click();
    }

    public boolean isOrderButtonPresent() {
        return orderButton.isElementPresent();
    }

    public OrderPage clickOrderButton() {
        orderButton.click();
        return new OrderPage(driver);
    }
}
