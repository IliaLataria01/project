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
        Assert.assertTrue(homePage.isPageOpened(),"Home Page was not opened.");
        ProductPage productPage = homePage.getProductComponent().clickProduct((R.TESTDATA.get("productName")));
        productPage.addToCartProduct();
        CartPage cartPage = homePage.getMenuComponent().openCartPage();
        Assert.assertTrue(cartPage.isOrderButtonPresent(), "Order Button was not present.");
        OrderPage orderPage = cartPage.clickOrderButton();
        Assert.assertTrue(orderPage.isNameFieldPresent(), "Name Field is not present.");
        Assert.assertTrue(orderPage.isCountryFieldPresent(), "Country Field is not present.");
        Assert.assertTrue(orderPage.isCityFieldPresent(), "City Field is not present.");
        Assert.assertTrue(orderPage.isCardFieldPresent(), "Card Field is not present.");
        Assert.assertTrue(orderPage.isMonthFieldPresent(), "Month Field is not present.");
        Assert.assertTrue(orderPage.isYearFieldPresent(), "Year Field is not present.");
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

    @Test
    public void additionOfProductInTheCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Home Page was not opened.");
        Assert.assertTrue(homePage.getProductComponent().isContainerPresent(),"Container is not present.");
        ProductPage productPage = homePage.getProductComponent().clickProduct((R.TESTDATA.get("productName")));
        productPage.addToCartProduct();
        CartPage cartPage = homePage.getMenuComponent().openCartPage();
        ContactPage page = cartPage.getTopBarMenu().openContactPage();
        Assert.assertTrue(page.isSendMessageButtonPresent(), "Message button is not opened.");
    }

    @Test
    public void removalFromCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(),"Home Page was not opened.");
        ProductPage productPage = homePage.getProductComponent().clickProduct((R.TESTDATA.get("productName")));
        productPage.addToCartProduct();
        CartPage cartPage = homePage.getMenuComponent().openCartPage();
        cartPage.removeProductFromCart(R.TESTDATA.get("productName"));
        Assert.assertFalse(cartPage.isProductPresent(R.TESTDATA.get("productName")), "Product was not deleted.");
    }
}
