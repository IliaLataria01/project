package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FilterPageBase extends AbstractPage {

    public FilterPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void filterAToZ();

    public abstract void filterZToA();

    public abstract void filterPriceLowerToHigh();

    public abstract void filterPriceHighToLower();

    public abstract boolean isAToZButtonPresent();

    public abstract boolean isZToAButtonPresent();

    public abstract boolean isPriceLowerToHighButtonPresent();

    public abstract boolean isPriceHigherToLowerButtonPresent();


}
