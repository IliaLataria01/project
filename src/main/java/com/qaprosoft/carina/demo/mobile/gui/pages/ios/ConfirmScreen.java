package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ConfirmScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ConfirmScreenBase.class)

public class ConfirmScreen extends ConfirmScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(ConfirmScreen.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"FINISH\"`][1]")
    private ExtendedWebElement finishButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"BACK HOME\"`][1]")
    private ExtendedWebElement backHomeButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"THANK YOU FOR YOU ORDER\"`]")
    private ExtendedWebElement orderAcceptanceText;


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
        return orderAcceptanceText.isElementPresent();
    }
}
