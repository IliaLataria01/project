package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(ProductPage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeLink[`label == \"Add to cart\"`]")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Close\"`]")
    private ExtendedWebElement closeButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isElementPresent();
    }

    public boolean isCloseButtonPresent() {
        return closeButton.isElementPresent();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void addToCartProduct() {
        addToCartButton.click();
    }
}
