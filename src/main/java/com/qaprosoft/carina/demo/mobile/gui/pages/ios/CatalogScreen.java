package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogScreenBase.class)
public class CatalogScreen extends CatalogScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(CatalogScreen.class);

    @ExtendedFindBy(image = "images/grid.png")
    private ExtendedWebElement  gridViewButton;

    @ExtendedFindBy(image = "images/layer.png")
    private ExtendedWebElement layerViewButton;

    @ExtendedFindBy(iosPredicate = "label == 'PRODUCTS' AND name == 'PRODUCTS' AND type == 'XCUIElementTypeOther'")
    private ExtendedWebElement productBar;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Modal Selector Button'`]")
    private ExtendedWebElement filterButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == '%s'`]")
    private ExtendedWebElement specificProductTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Cart\"`]")
    private ExtendedWebElement cartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Menu\"`]")
    private ExtendedWebElement menuButton;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label CONTAINS '%s'`][2]/**/XCUIElementTypeOther[`label == \"REMOVE\"`][1]")
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
    public boolean isLayerViewButtonPresent() {
        return layerViewButton.isElementPresent();
    }

    @Override
    public boolean isGridViewButtonPresent() {
        return gridViewButton.isElementPresent();
    }

    @Override
    public void clickLayerViewButton() {
        layerViewButton.click();
    }

    @Override
    public void clickGridViewButton() {
        gridViewButton.click();
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
