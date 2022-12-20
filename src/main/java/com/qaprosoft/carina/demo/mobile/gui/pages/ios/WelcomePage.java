package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {
    private static final Logger LOGGER = LogManager.getLogger(WelcomePage.class);


    @FindBy(xpath = "label == 'PRODUCTS' AND name == 'PRODUCTS' AND type == 'XCUIElementTypeOther'")
    @Predicate
    private ExtendedWebElement productBar;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Modal Selector Button'`]")
    private ExtendedWebElement filterButton;


    @FindBy(xpath = "name == 'test-Toggle'")
    @Predicate
    private ExtendedWebElement viewButton;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == '%s'`]")
    private ExtendedWebElement product;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"test-Cart\"`]")
    private ExtendedWebElement cartButton;

    private int count = 0;


    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductBarPresent() {
        return productBar.isElementPresent();
    }

    @Override
    public FilterPageBase clickFilterButton() {
        filterButton.click();
        return initPage(getDriver(), FilterPageBase.class);
    }

    @Override
    public boolean isFilterButtonPresent() {
        return filterButton.isElementPresent();
    }

    @Override
    public void changeProductView(String view) {
        if (view.equalsIgnoreCase("grid")) {
            if (count % 2 != 0) {
                viewButton.click();
                count++;
            }
        } else if (view.equalsIgnoreCase("layer")) {
            if (count % 2 == 0) {
                viewButton.click();
                count++;
            }
        }
    }

    @Override
    public boolean isViewButtonPresent() {
        return viewButton.isElementPresent();
    }


    @Override
    public ProductPageBase clickProduct(String productName) {
        product.format(productName).click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public boolean isClickProductButtonPresent() {
        return product.isElementPresent();
    }

    @Override
    public void clickCartButton() {
        cartButton.click();
    }

}
