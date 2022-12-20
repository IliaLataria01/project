package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WelcomePageBase clickBackButton();

    public abstract boolean isBackButtonPresent();

    public abstract void addToCart();

}
