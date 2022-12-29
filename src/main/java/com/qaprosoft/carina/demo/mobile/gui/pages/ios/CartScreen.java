package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(CartScreen.class);

    @FindBy(id = "%s")
    private ExtendedWebElement selectedProduct;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"CHECKOUT\"`][1]")
    private ExtendedWebElement checkoutButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"CONTINUE SHOPPING\"`][1]")
    private ExtendedWebElement continueShoppingButton;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductPresent(String productName) {
        return selectedProduct.format(productName).isElementPresent();
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isElementPresent();
    }

    @Override
    public boolean isContinueShoppingButtonPresent() {
        return continueShoppingButton.isElementPresent();
    }

    @Override
    public CheckoutScreenBase clickCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutScreenBase.class);
    }

    @Override
    public CatalogScreenBase clickContinueShoppingButton() {
        continueShoppingButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }
}
