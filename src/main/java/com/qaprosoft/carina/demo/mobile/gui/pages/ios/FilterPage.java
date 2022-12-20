package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FilterPageBase.class)
public class FilterPage extends FilterPageBase {


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


    public FilterPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void filterAToZ() {
        fromAToZ.click();
    }

    @Override
    public void filterZToA() {
        fromZToA.click();
    }

    @Override
    public void filterPriceLowerToHigh() {
        fromLowerToHigh.click();
    }

    @Override
    public void filterPriceHighToLower() {
        fromHigherToLower.click();
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
