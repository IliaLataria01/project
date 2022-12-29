package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutScreenBase extends AbstractPage {
    public CheckoutScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFirstNameFieldPresent();

    public abstract boolean isLastNameFieldPresent();

    public abstract boolean isPostalCodeFieldPresent();

    public abstract void typeFirstName(String firstName);

    public abstract void typeLastName(String lastName);

    public abstract void typePostalCode(String postalCode);

    public abstract ConfirmScreenBase clickContinueButton();

    public abstract boolean isContinueButtonPresent();

}
