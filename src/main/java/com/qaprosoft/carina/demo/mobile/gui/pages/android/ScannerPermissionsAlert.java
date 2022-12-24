package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ScannerScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.modals.ScannerPermissionsAlertBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE,parentClass = ScannerPermissionsAlertBase.class)
public class ScannerPermissionsAlert extends ScannerPermissionsAlertBase {

    @FindBy(xpath = "//*[@text='Only this time']")
    private ExtendedWebElement allowButton;

    public ScannerPermissionsAlert(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOkButtonPresent() {
        return allowButton.isElementPresent();
    }

    @Override
    public ScannerScreenBase clickOkButton() {
        allowButton.click();
        return initPage(getDriver(),ScannerScreenBase.class);
    }
}
