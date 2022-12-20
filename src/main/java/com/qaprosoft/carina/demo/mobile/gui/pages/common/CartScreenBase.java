package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartScreenBase extends AbstractPage {
    public CartScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductPresent(String productName);
}
