package com.qaprosoft.carina.demo.gui.webtest.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.webtest.ios.components.CategoryComponent;
import com.qaprosoft.carina.demo.gui.webtest.ios.components.MenuComponent;
import com.qaprosoft.carina.demo.gui.webtest.ios.components.ProductComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"navigation\"`]/XCUIElementTypeOther")
    private MenuComponent menuComponent;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"STORE\"`]")
    private ProductComponent productComponent;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"STORE\"`]")
    private CategoryComponent categoryComponent;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Next\"`]")
    private ExtendedWebElement nextPage;


    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(nextPage);
    }

    public boolean isNextPageButtonPresent() {
        return nextPage.isElementPresent();
    }

    public MenuComponent getMenuComponent() {
        return menuComponent;
    }

    public ProductComponent getProductComponent() {
        return productComponent;
    }

    public CategoryComponent getCategoryComponent() {
        return categoryComponent;
    }

}


