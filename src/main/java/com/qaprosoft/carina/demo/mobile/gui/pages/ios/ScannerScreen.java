package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ScannerScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ScannerScreenBase.class)
public class ScannerScreen extends ScannerScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(ScannerScreen.class);


    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private ExtendedWebElement allowButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"Scan a QR Code that contains a url. It will be opened in the default browser.\"`][3]")
    private ExtendedWebElement qRCode;

    public ScannerScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOkButton() {
        allowButton.click();
    }

    @Override
    public boolean isOkButtonPresent() {
        return allowButton.isElementPresent();
    }

    @Override
    public boolean isQRCodeRepresentationPresent() {
        return qRCode.isElementPresent();
    }

}