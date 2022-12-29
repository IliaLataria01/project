package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.modals.SignaturePermissionsAlertBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SignaturePermissionsAlertBase.class)
public class SignaturePermissionsAlert extends SignaturePermissionsAlertBase {
    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement doNowAllowButton;
    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okButton;

    public SignaturePermissionsAlert(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDoNotAllowButtonPresent() {
        return doNowAllowButton.isElementPresent();
    }

    @Override
    public void clickDoNotAllowButton() {
        doNowAllowButton.click();
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
