package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CatalogScreenBase extends AbstractPage {
    public CatalogScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductBarPresent();

    public abstract FilterScreenBase clickFilterButton();

    public abstract boolean isFilterButtonPresent();


    public abstract ProductScreenBase clickProduct(String productName);

    public abstract boolean isClickProductButtonPresent();

    public abstract CartScreenBase clickCartButton();

    public abstract MenuScreenBase clickMenuButton();

    public abstract boolean isMenuClickButtonPresent();

    public abstract void clickRemovalButton(String productName);

    public abstract boolean isRemovalButtonPresent(String productName);

    public abstract boolean isLayerViewButtonPresent();

    public abstract boolean isGridViewButtonPresent();

    public abstract void clickLayerViewButton();

    public abstract void clickGridViewButton();

}
