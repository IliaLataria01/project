package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ScannerScreenBase extends AbstractPage {
    public ScannerScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOkButton();

    public abstract boolean isOkButtonPresent();

    public abstract boolean isQRCodeRepresentationPresent();
}
