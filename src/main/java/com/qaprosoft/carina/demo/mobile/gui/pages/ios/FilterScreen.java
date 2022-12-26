package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.enums.FilterOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

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
    public void clickFilterOption(FilterOption filterOption) {
        switch (filterOption) {
            case FROM_A_TO_Z:
                fromAToZ.click();
                break;
            case FROM_Z_TO_A:
                fromZToA.click();
                break;
            case FROM_LOWER_TO_HIGH:
                fromLowerToHigh.click();
                break;
            case FROM_HIGHER_TO_LOWER:
                fromHigherToLower.click();
                break;
        }
    }

    @Override
    public boolean isFilterPresent(FilterOption filterOption) {
        switch (filterOption) {
            case FROM_A_TO_Z:
                return fromAToZ.isElementPresent();
            case FROM_Z_TO_A:
                return fromZToA.isElementPresent();
            case FROM_LOWER_TO_HIGH:
                return fromLowerToHigh.isElementPresent();
            case FROM_HIGHER_TO_LOWER:
                return fromHigherToLower.isElementPresent();
        }
        return false;
    }
}
