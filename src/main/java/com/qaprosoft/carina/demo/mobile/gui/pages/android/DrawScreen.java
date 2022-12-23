package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DrawScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawScreenBase.class)
public class DrawScreen extends DrawScreenBase {

    private static final Logger LOGGER = LogManager.getLogger(DrawScreen.class);


    @FindBy(xpath = "//*[@content-desc='test-SAVE']")
    private ExtendedWebElement saveButton;

    @FindBy(xpath = "//*[@resource-id='signature-pad']")
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
    public void clickSaveButton() {
        saveButton.click();
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
    public void drawSomething() {
        signatureField.click();
    }

    @Override
    public void draw(int startX, int startY, int endX, int endY, int duration) {

    }
}
