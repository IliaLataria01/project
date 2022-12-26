package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.enums.FilterOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterScreenBase.class)
public class FilterScreen extends FilterScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(FilterScreen.class);

    @FindBy(xpath = "//*[@text='Name (A to Z)']")
    private ExtendedWebElement fromAToZ;

    @FindBy(xpath = "//*[@text='Name (Z to A)']")
    private ExtendedWebElement fromZToA;

    @FindBy(xpath = "//*[@text='Price (low to high)']")
    private ExtendedWebElement fromLowerToHigh;

    @FindBy(xpath = "//*[@text='Price (high to low)']")
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
