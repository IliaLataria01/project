package com.qaprosoft.carina.demo.gui.test.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarouselComponent extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(CarouselComponent.class);

    @FindBy(xpath = "//div[@class='carousel-inner']//img")
    private List<ExtendedWebElement> items;

    @FindBy(xpath = "//a[@class='carousel-control-next']")
    private ExtendedWebElement nextItem;

    @FindBy(xpath = "//a[@class='carousel-control-prev']")
    private ExtendedWebElement previousItem;

    private int count = 0;

    public CarouselComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isProductPresent(int count) {
        return items.get(count).isElementPresent();
    }

    public boolean isNextButtonPresent() {
        return nextItem.isElementPresent();
    }

    public boolean isPreviousButtonPresent() {
        return previousItem.isElementPresent();
    }

    public int getCount() {
        return count;
    }

    public void clickRight() {
        nextItem.click();
        count++;
        if (count >= items.size()) {
            count = 0;
        }
    }

    public void clickLeft() {
        previousItem.click();
        count--;
        if (count < 0) {
            count = items.size() - 1;
        }
    }
}
