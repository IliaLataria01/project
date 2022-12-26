package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.enums.ProductViewOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(CatalogScreen.class);

    @FindBy(xpath = "//*[@text='PRODUCTS']")
    private ExtendedWebElement productBar;

    @FindBy(xpath = "//*[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement filterButton;

    @FindBy(xpath = "//*[@content-desc='test-Toggle']")
    private ExtendedWebElement viewButton;

    @FindBy(xpath = "//*[@text='%s']")
    private ExtendedWebElement specificProductTitle;

    @FindBy(xpath = "//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//*[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    private int count = 0;

    public CatalogScreen(WebDriver driver) {
        super(driver);
    }

    public boolean isProductBarPresent() {
        return productBar.isElementPresent();
    }

    @Override
    public FilterScreenBase clickFilterButton() {
        filterButton.click();
        return initPage(getDriver(), FilterScreenBase.class);
    }

    @Override
    public boolean isFilterButtonPresent() {
        return filterButton.isElementPresent();
    }

    @Override
    public boolean isViewButtonPresent() {
        return viewButton.isElementPresent();
    }

    @Override
    public boolean isClickProductButtonPresent() {
        return specificProductTitle.isElementPresent();
    }

    @Override
    public boolean isMenuClickButtonPresent() {
        return menuButton.isElementPresent();
    }

    @Override
    public boolean isRemovalButtonPresent(String productName) {
        return removeButton.format(productName).isElementPresent();
    }


    @Override
    public void changeProductView(ProductViewOptions viewOptions) {
        switch (viewOptions) {
            case GRID: {
                if (count % 2 != 0) {
                    viewButton.click();
                    count++;
                }
            }
            case LAYER: {
                if (count % 2 == 0) {
                    viewButton.click();
                    count++;
                }
            }
        }
    }

    @Override
    public ProductScreenBase clickProduct(String productName) {
        specificProductTitle.format(productName).click();
        return initPage(getDriver(), ProductScreenBase.class);
    }

    @Override
    public CartScreenBase clickCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartScreenBase.class);
    }

    @Override
    public MenuScreenBase clickMenuButton() {
        menuButton.click();
        return initPage(getDriver(), MenuScreenBase.class);
    }

    @Override
    public void clickRemovalButton(String productName) {
        removeButton.format(productName).click();
    }

}
