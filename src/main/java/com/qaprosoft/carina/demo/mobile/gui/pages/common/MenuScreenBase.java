package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.MenuOptions;
import org.openqa.selenium.WebDriver;

public abstract class MenuScreenBase extends AbstractPage {
    public MenuScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickCloseButton();

    public abstract boolean isCloseButtonPresent();

    public abstract boolean checkMenuOption(MenuOptions menuOption);


    public abstract AbstractPage clickMenuOption(MenuOptions option);

}
