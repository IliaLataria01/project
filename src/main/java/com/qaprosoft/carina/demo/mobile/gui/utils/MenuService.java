package com.qaprosoft.carina.demo.mobile.gui.utils;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.enums.MenuOption;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.MenuScreenBase;
import org.testng.Assert;

public class MenuService implements IAbstractTest {

    public MenuScreenBase menuService() {
        AuthService authService = new AuthService();
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(), "Menu click button is not present");
        return catalogScreen.clickMenuButton();
    }

    public AbstractPage open(MenuOption menuOption) {
        AuthService authService = new AuthService();
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(), "Menu click button is not present");
        MenuScreenBase menuScreen = catalogScreen.clickMenuButton();
        return menuScreen.clickMenuOption(menuOption);
    }
}
