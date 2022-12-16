package com.qaprosoft.carina.demo.mytests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.test.page.CartPage;
import com.qaprosoft.carina.demo.gui.test.page.ConfirmationPage;
import com.qaprosoft.carina.demo.gui.test.page.OrderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest implements IAbstractTest {

    @Test
    public void orderTest() {
        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();
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
        ConfirmationPage confirmationPage = orderPage.clickPurchaseButton();
        confirmationPage.clickConfirmButton();
    }
}
