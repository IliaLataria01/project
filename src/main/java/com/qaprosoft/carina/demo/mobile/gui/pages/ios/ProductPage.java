package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {


    @ExtendedFindBy(iosPredicate = "label == \"BACK TO PRODUCTS\" AND name == \"test-BACK TO PRODUCTS\"")
    private ExtendedWebElement backButton;

    @ExtendedFindBy(iosPredicate = "label == \"ADD TO CART\" AND name == \"test-ADD TO CART\"")
    private ExtendedWebElement addToCart;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WelcomePageBase clickBackButton() {
        backButton.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }

    @Override
    public boolean isBackButtonPresent() {
        return backButton.isElementPresent();
    }

    @Override
    public void addToCart() {
        addToCart.click();
    }

}
