package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartScreenBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartScreenBase.class)
public class CartScreen extends CartScreenBase {

    @FindBy(id = "%s")
    private ExtendedWebElement selectedProduct;

    public CartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isProductPresent(String productName) {
        return selectedProduct.format(productName).isElementPresent();
    }
}
