package com.qaprosoft.carina.demo.gui.test.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.test.page.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductComponent extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(ProductComponent.class);

    @FindBy(xpath = "//*[@id='tbodyid']//a[@class='hrefch']")
    private List<ExtendedWebElement> productElement;

    @FindBy(xpath = "//*[@id='tbodyid']")
    private ExtendedWebElement container;


    public ProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public boolean isContainerPresent() {
        return container.isElementPresent();
    }

    public ProductPage clickProduct(String product) {
        for (ExtendedWebElement element : productElement) {
            String text = element.getText();
            if (product.equalsIgnoreCase(text)) {
                element.click();
                return new ProductPage(driver);
            }
        }
        throw new IllegalArgumentException("Product is not available");
    }
}
