package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.FilterOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FilterScreenBase.class)
public class FilterScreen extends FilterScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(FilterScreen.class);

    @ExtendedFindBy(iosPredicate = "label == 'Name (A to Z)'")
    public ExtendedWebElement fromAToZ;

    @ExtendedFindBy(iosPredicate = "label == 'Name (Z to A)'")
    private ExtendedWebElement fromZToA;

    @ExtendedFindBy(iosPredicate = "label == 'Price (low to high)'")
    private ExtendedWebElement fromLowerToHigh;

    @ExtendedFindBy(iosPredicate = "label == 'Horizontal scroll bar, 2 pages'")
    private ExtendedWebElement fromHigherToLower;


    public FilterScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickFilterOption(FilterOption filterOptions) {
        switch (filterOptions.getOption()) {
            case "A to Z":
                fromAToZ.click();
                break;
            case "Z to A":
                fromZToA.click();
                break;
            case "Low to High":
                fromLowerToHigh.click();
                break;
            case "High to Low":
                fromHigherToLower.click();
                break;
        }
    }

    @Override
    public boolean isFilterPresent(FilterOption filterOption) {
        switch (filterOption) {
            case FROMATOZ:
                return fromAToZ.isElementPresent();
            case FROMZTOA:
                return fromZToA.isElementPresent();
            case FROMLOWERTOHIGH:
                return fromLowerToHigh.isElementPresent();
            case FROMHIGHERTOLOWER:
                return fromHigherToLower.isElementPresent();
        }
        return false;
    }
}
