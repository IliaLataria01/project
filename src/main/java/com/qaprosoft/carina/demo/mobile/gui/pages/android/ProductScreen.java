package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductScreenBase.class)
public class ProductScreen extends ProductScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(ProductScreen.class);

    @FindBy(xpath = "//*[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCart;

    @FindBy(xpath = "//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//*[@content-desc='test-BACK TO PRODUCTS']")
    private ExtendedWebElement backButton;

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
    public void clickAddToCartButton() {
        addToCart.click();
    }

    @Override
    public CartScreenBase clickCartButton() {
        cartButton.click();
        return initPage(getDriver(), CartScreenBase.class);
    }

    @Override
    public boolean isCartButtonPresent() {
        return cartButton.isElementPresent();
    }
}
