package com.qaprosoft.carina.demo.gui.webtest.ios.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.webtest.common.enums.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;


public class CategoryComponent extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(CategoryComponent.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeLink[`label == '%s'`]")
    private ExtendedWebElement categoryItem;

    public CategoryComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public boolean isCategoryPresent(Category category) {
        return categoryItem.format(category.getName()).isElementPresent();
    }

    public void switchCategory(Category category) {
        switch (category) {
            case MIX:
                categoryItem.format(category.getName()).click();
            case PHONES:
                categoryItem.format(category.getName()).click();
            case LAPTOPS:
                categoryItem.format(category.getName()).click();
            case MONITORS:
                categoryItem.format(category.getName()).click();
        }
    }
}
