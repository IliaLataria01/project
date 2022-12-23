package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ConfirmScreenBase extends AbstractPage {
    public ConfirmScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFinishButtonPresent();

    public abstract void clickFinishButton();

    public abstract boolean isGoBackButtonPresent();

    public abstract CatalogScreenBase clickGoBackButton();

    public abstract boolean isOrderAcceptanceText();
}
