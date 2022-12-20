package com.qaprosoft.carina.demo.mobile.gui.pages.common;


import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawScreenBase extends AbstractPage {

    public DrawScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isSaveButtonPresent();

    public abstract void clickSaveButton();

    public abstract boolean isOkButtonPresent();

    public abstract void clickOkButton();

    public abstract void drawSomething();

}
