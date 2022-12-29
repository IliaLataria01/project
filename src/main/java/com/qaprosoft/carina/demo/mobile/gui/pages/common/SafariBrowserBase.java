package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.AboutMenuOptions;
import org.openqa.selenium.WebDriver;

public abstract class SafariBrowserBase extends AbstractPage {
    public SafariBrowserBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isMenuOptionPresent(AboutMenuOptions aboutMenuOption);

    public abstract boolean isCloseButtonPresent();

    public abstract void  clickCloseButton();
}
