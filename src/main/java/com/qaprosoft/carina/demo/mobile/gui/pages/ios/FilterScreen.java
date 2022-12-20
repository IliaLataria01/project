package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.FilterOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FilterScreenBase.class)
public class FilterScreen extends FilterScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(FilterScreen.class);


    @FindBy(xpath = "label == 'Name (A to Z)'")
    @Predicate
    public ExtendedWebElement fromAToZ;

    @FindBy(xpath = "label == 'Name (Z to A)'")
    @Predicate
    private ExtendedWebElement fromZToA;

    @FindBy(xpath = "label == 'Price (low to high)'")
    @Predicate
    private ExtendedWebElement fromLowerToHigh;

    @FindBy(xpath = "label == 'Horizontal scroll bar, 2 pages'")
    @Predicate
    private ExtendedWebElement fromHigherToLower;


    public FilterScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickFilterOption(FilterOptions filterOptions) {
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
    public boolean isAToZButtonPresent() {
        return fromAToZ.isElementPresent();
    }

    @Override
    public boolean isZToAButtonPresent() {
        return fromZToA.isElementPresent();
    }

    @Override
    public boolean isPriceLowerToHighButtonPresent() {
        return fromLowerToHigh.isElementPresent();
    }

    @Override
    public boolean isPriceHigherToLowerButtonPresent() {
        return fromHigherToLower.isElementPresent();
    }
}
