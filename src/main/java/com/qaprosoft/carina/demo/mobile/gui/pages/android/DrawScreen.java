package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DrawScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignaturePermissionsAlertBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawScreenBase.class)
public class DrawScreen extends DrawScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(DrawScreen.class);

    @FindBy(xpath = "//*[@content-desc='test-SAVE']")
    private ExtendedWebElement saveButton;

    @FindBy(id = "test-DRAWING-SCREEN]")
    private ExtendedWebElement signatureField;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okButton;

    public DrawScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSaveButtonPresent() {
        return saveButton.isElementPresent();
    }

    @Override
    public SignaturePermissionsAlertBase clickSaveButton() {
        saveButton.click();
        return initPage(getDriver(), SignaturePermissionsAlertBase.class);
    }

    @Override
    public boolean isOkButtonPresent() {
        return okButton.isElementPresent();
    }

    @Override
    public void clickOkButton() {
        okButton.click();
    }

    @Override
    public boolean isDrawContainerPresent() {
        return signatureField.isElementPresent();
    }


    @Override
    public boolean draw() {
        return swipeInContainer(signatureField, Direction.DOWN, 2000);
    }
}
