package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RandomScreenBase extends AbstractPage {
    public RandomScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoPresent();
}
