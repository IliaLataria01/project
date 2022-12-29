package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ScannerScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ScannerPermissionsAlertBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = ScannerPermissionsAlertBase.class)
public class ScannerPermissionsAlert extends ScannerPermissionsAlertBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
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
