package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ConfirmScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ConfirmScreenBase.class)
public class ConfirmScreen extends ConfirmScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(ConfirmScreen.class);


    @FindBy(xpath = "//*[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//*[@content-desc='test-BACK HOME']")
    private ExtendedWebElement backHomeButton;

    public ConfirmScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFinishButtonPresent() {
        return finishButton.isElementPresent();
    }

    @Override
    public void clickFinishButton() {
        finishButton.click();
    }

    @Override
    public boolean isGoBackButtonPresent() {
        return backHomeButton.isElementPresent();
    }

    @Override
    public CatalogScreenBase clickGoBackButton() {
        backHomeButton.click();
        return initPage(getDriver(), CatalogScreenBase.class);
    }

    @Override
    public boolean isOrderAcceptanceText() {
        return false;
    }
}
