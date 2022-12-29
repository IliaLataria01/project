package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.DrawScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.SignaturePermissionsAlertBase;
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

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == \"Vertical scroll bar, 1 page Horizontal scroll bar, 1 page\"`][1]")
    private ExtendedWebElement signatureField;


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
        return initPage(getDriver(),SignaturePermissionsAlertBase.class);
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
        return swipeInContainer(signatureField,Direction.DOWN,2000);
    }
}
