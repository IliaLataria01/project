package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(ProductScreen.class);


    @ExtendedFindBy(iosPredicate = "label == \"BACK TO PRODUCTS\" AND name == \"test-BACK TO PRODUCTS\"")
    private ExtendedWebElement backButton;

    @ExtendedFindBy(iosPredicate = "label == \"ADD TO CART\" AND name == \"test-ADD TO CART\"")
    private ExtendedWebElement addToCart;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Cart\"`]/XCUIElementTypeOther")
    private ExtendedWebElement cartButton;

    public ProductScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CatalogScreenBase clickBackButton() {
        backButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }

    @Override
    public boolean isBackButtonPresent() {
        return backButton.isElementPresent();
    }

    @Override
    public void addToCart() {
        addToCart.click();
    }

    @Override
    public CartScreenBase clickCartButton() {
        cartButton.click();
        return initPage(getDriver(),CartScreenBase.class);
    }

    @Override
    public boolean isClickCartButton() {
        return cartButton.isElementPresent();
    }

}
