package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DrawScreenBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawScreenBase.class)
public class DrawScreen extends DrawScreenBase {
    private static final Logger LOGGER = LogManager.getLogger(DrawScreen.class);



    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"SAVE\"`][1]")
    private ExtendedWebElement saveButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"OK\"`]")
    private ExtendedWebElement okButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"Signature Pad demo\"`]")
    private ExtendedWebElement signatureField;


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
        // This is first Variant to call longPress
//        longPress(signatureField);
        // Second variant is to to call swipe straight (189,260) to (189,620)
//        swipe(189,260,189,620,2500);
        // Third variant
        swipe(signatureField);
    }
}