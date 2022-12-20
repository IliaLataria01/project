package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.FilterOptions;
import org.openqa.selenium.WebDriver;

public abstract class FilterScreenBase extends AbstractPage {

    public FilterScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickFilterOption(FilterOptions filterOptions);

    public abstract boolean isAToZButtonPresent();

    public abstract boolean isZToAButtonPresent();

    public abstract boolean isPriceLowerToHighButtonPresent();

    public abstract boolean isPriceHigherToLowerButtonPresent();


}
