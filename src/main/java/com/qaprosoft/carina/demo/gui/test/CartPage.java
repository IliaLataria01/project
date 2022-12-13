package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://demoblaze.com/cart.html#");
    }


}
