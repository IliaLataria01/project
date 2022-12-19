package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.test.components.CarouselComponent;
import com.qaprosoft.carina.demo.gui.test.components.CategoryComponent;
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

    @FindBy(xpath = "//div[@class='list-group']")
    private CategoryComponent categoryComponent;

    @FindBy(id = "next2")
    private ExtendedWebElement nextPage;

    @FindBy(xpath = "//div[@class='carousel-inner']")
    private CarouselComponent carouselComponent;

    @FindBy(id = "tbodyid")
    private ExtendedWebElement container;

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

    public boolean isContainerPresent() {
        return container.isElementPresent();
    }

    public ProductComponent getProductComponent() {
        return productComponent;
    }

    public CategoryComponent getCategoryComponent() {
        return categoryComponent;
    }

    public CarouselComponent getCarouselComponent() {
        return carouselComponent;
    }
}
