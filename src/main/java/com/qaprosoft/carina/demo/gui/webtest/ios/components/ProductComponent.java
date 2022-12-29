package com.qaprosoft.carina.demo.gui.webtest.ios.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qaprosoft.carina.demo.gui.webtest.ios.page.ProductPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductComponent extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(ProductComponent.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == '%s'`]")
    private ExtendedWebElement productElement;

    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public ProductPage clickProduct(String product) {
        productElement.format(product).click();
        return new ProductPage(driver);
    }
}
