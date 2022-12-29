package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.modals.SignaturePermissionsAlertBase;
import org.openqa.selenium.WebDriver;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SignaturePermissionsAlertBase.class)
public class SignaturePermissionsAlert extends SignaturePermissionsAlertBase {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Don’t Allow\"`]")
    private ExtendedWebElement doNotAllowButton;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private ExtendedWebElement okButton;

    public SignaturePermissionsAlert(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDoNotAllowButtonPresent() {
        return doNotAllowButton.isElementPresent();
    }

    @Override
    public void clickDoNotAllowButton() {
        doNotAllowButton.click();
    }

    @Override
    public boolean isOkButtonPresent() {
        return okButton.isElementPresent();
    }

    @Override
    public void clickOkButton() {
        okButton.click();
    }
}
