package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.test.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest implements IAbstractTest {

    @Test
    public void orderTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ProductPage productPage = homePage.getProductComponent().clickProduct((R.TESTDATA.get("productName")));
        productPage.addToCartProduct();
        CartPage cartPage = homePage.getMenuComponent().openCartPage();
        Assert.assertTrue(cartPage.isOrderButtonPresent(), "Order Button was not present.");
        OrderPage orderPage = cartPage.clickOrderButton();
        orderPage.fillTheForm(
                R.TESTDATA.get("user_name"),
                R.TESTDATA.get("country"),
                R.TESTDATA.get("city"),
                R.TESTDATA.get("card"),
                R.TESTDATA.get("month"),
                R.TESTDATA.get("year")
        );
        Assert.assertTrue(orderPage.isPurchaseButtonPresent(), "Purchase Button was not present.");
        ConfirmationPage confirmationPage = orderPage.clickPurchaseButton();
        Assert.assertTrue(confirmationPage.isConfirmButtonPresent(), "Confirm button was not present.");
        confirmationPage.clickConfirmButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home Page was not opened.");
    }
}
