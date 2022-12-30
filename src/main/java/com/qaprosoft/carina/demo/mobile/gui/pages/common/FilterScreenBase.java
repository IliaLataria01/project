package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.enums.FilterOption;
import org.openqa.selenium.WebDriver;

public abstract class FilterScreenBase extends AbstractPage {

    public FilterScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickFilterOption(FilterOption filterOption);

    public abstract boolean isFilterPresent(FilterOption filterOption);


}
