package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.enums.AboutMenuOptions;
import org.openqa.selenium.WebDriver;

public abstract class MenuAboutScreenBase extends AbstractPage {

    public MenuAboutScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isMenuOptionPresent(AboutMenuOptions aboutMenuOption);

    public abstract boolean isCloseButtonPresent();

    public abstract void  clickCloseButton();

}
