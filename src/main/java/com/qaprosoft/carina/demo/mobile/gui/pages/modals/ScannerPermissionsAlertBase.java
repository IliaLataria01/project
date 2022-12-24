package com.qaprosoft.carina.demo.mobile.gui.pages.modals;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ScannerScreenBase;
import org.openqa.selenium.WebDriver;

public abstract class ScannerPermissionsAlertBase extends AbstractPage {
    public ScannerPermissionsAlertBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOkButtonPresent();

    public abstract ScannerScreenBase clickOkButton();
}
