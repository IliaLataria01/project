package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CheckoutScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ConfirmScreenBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ConfirmScreenBase.class)

public class ConfirmScreen extends ConfirmScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"FINISH\"`][1]")
    private ExtendedWebElement finishButton;


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"BACK HOME\"`][1]")
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
        return initPage(getDriver(),CatalogScreenBase.class);
    }
}
