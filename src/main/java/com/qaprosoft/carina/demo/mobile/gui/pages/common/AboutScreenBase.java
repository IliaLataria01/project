package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AboutScreenBase extends AbstractPage {
    public AboutScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isHomeButtonPresent();

    public abstract boolean isMenuButtonPresent();

    public abstract MenuAboutScreenBase clickMenuButton();
}
