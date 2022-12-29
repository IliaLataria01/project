package com.qaprosoft.carina.demo.mobile.gui.pages.utils;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductScreenBase;
import org.testng.Assert;

public class CartAdditionService implements IAbstractTest {

    public CartScreenBase addProduct(String productName) {
        AuthService authService = new AuthService();
        CatalogScreenBase welcomeScreen = authService.login();
        ProductScreenBase productScreen = welcomeScreen.clickProduct(productName);
        Assert.assertTrue(productScreen.isBackButtonPresent(), "Back button is not present.");
        productScreen.clickAddToCartButton();
        Assert.assertTrue(productScreen.isCartButtonPresent(), "Cart button is not present.");
        CartScreenBase cartScreen = productScreen.clickCartButton();
        Assert.assertTrue(cartScreen.isProductPresent(productName));
        return cartScreen;
    }
}
