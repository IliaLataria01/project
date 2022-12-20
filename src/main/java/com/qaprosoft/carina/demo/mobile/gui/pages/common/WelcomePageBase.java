package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {
    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductBarPresent();

    public abstract FilterPageBase clickFilterButton();

    public abstract boolean isFilterButtonPresent();

    public abstract void changeProductView(String view);

    public abstract boolean isViewButtonPresent();

    public abstract ProductPageBase clickProduct(String productName);

    public abstract boolean isClickProductButtonPresent();


    public abstract void clickCartButton();

}
