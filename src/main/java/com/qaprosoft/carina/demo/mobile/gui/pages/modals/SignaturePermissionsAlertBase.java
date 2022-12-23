package com.qaprosoft.carina.demo.mobile.gui.pages.modals;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignaturePermissionsAlertBase extends AbstractPage {
    public SignaturePermissionsAlertBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDoNotAllowButtonPresent();

    public abstract void clickDoNotAllowButton();

    public abstract boolean isOkButtonPresent();

    public abstract void clickOkButton();
}
