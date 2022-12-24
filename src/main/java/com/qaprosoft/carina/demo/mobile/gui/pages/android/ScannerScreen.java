package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ScannerScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ScannerScreenBase.class)
public class ScannerScreen extends ScannerScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(ScannerScreen.class);

    @FindBy(xpath = "//*[@resource_id='com.swaglabsmobileapp:id/texture_view']")
    private ExtendedWebElement qRCode;

    public ScannerScreen(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isQRCodeRepresentationPresent() {
        return qRCode.isElementPresent();
    }
}
