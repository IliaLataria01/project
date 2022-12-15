package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.test.components.MenuComponent;
import com.qaprosoft.carina.demo.gui.test.components.ProductComponent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(id = "navbarExample")
    private MenuComponent menuComponent;

    @FindBy(id = "tbodyid")
    private ProductComponent productComponent;

    @FindBy(id = "next2")
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


}
