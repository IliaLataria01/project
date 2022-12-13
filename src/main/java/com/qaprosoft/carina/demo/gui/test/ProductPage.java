package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(ProductPage.class);

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[4]/a")
    private ExtendedWebElement cartButton;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isElementPresent();
    }

    public boolean isCartButtonPresent() {
        return cartButton.isElementPresent();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

}
