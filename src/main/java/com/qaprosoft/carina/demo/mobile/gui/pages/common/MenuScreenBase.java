package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.MenuOption;
import org.openqa.selenium.WebDriver;

public abstract class MenuScreenBase extends AbstractPage {
    public MenuScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickCloseButton();

    public abstract boolean isCloseButtonPresent();

    public abstract boolean checkMenuOption(MenuOption menuOption);


    public abstract AbstractPage clickMenuOption(MenuOption option);

}
