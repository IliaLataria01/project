package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductScreenBase extends AbstractPage {
    public ProductScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract CatalogScreenBase clickBackButton();

    public abstract boolean isBackButtonPresent();

    public abstract void clickAddToCartButton();

    public abstract CartScreenBase clickCartButton();

    public abstract boolean isCartButtonPresent();

}
