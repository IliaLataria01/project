package com.qaprosoft.carina.demo.gui.test;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.test.components.ProductComponent;

import com.qaprosoft.carina.demo.gui.test.components.TopBarMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(id = "navbarExample")
    private TopBarMenu topBarMenu;

    @FindBy(xpath = "//*[@class=\"col-lg-4 col-md-6 mb-4\"]")
    private List<ExtendedWebElement> productList;

    @FindBy(id = "tbodyid")
    private ProductComponent productComponent;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public TopBarMenu getTopBarMenu() {
        return topBarMenu;
    }

    public ProductComponent getProductComponent() {
        return productComponent;
    }



}
