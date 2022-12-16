package com.qaprosoft.carina.demo.gui.test.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryComponent extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(CategoryComponent.class);

    @FindBy(id = "cat")
    private ExtendedWebElement mix;

    @FindBy(xpath = "//a[@id='itemc' and contains(text(),'%s')]")
    private ExtendedWebElement categoryItem;

    @FindBy(id = "tbodyid")
    private ExtendedWebElement productContainer;

    @FindBy(xpath = "//div[@id='tbodyid']//div")
    private List<ExtendedWebElement> products;

    public CategoryComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isProductContainerPresent() {
        return productContainer.isElementPresent();
    }

    public boolean checkProducts() {
        return products.size() >= 1;
    }

    public void switchCategory(Category category) {
        switch (category) {
            case MIX:
                mix.click();
            case PHONES:
                categoryItem.format(category.getName()).click();
            case LAPTOPS:
                categoryItem.format(category.getName()).click();
            case MONITORS:
                categoryItem.format(category.getName()).click();
        }
    }
}
