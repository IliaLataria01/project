package com.qaprosoft.carina.demo.mobile.gui.pages.common;


import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.modals.SignaturePermissionsAlertBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class DrawScreenBase extends AbstractPage implements IMobileUtils {

    public DrawScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSaveButtonPresent();

    public abstract SignaturePermissionsAlertBase clickSaveButton();

    public abstract boolean isOkButtonPresent();

    public abstract void clickOkButton();

    public abstract boolean isDrawContainerPresent();

    public abstract boolean draw();

}
