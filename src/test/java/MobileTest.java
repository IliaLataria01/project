import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.FilterOptions;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.ProductViewOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MobileTest implements IAbstractTest {

    // First Test Case (Works)
    @Test
    public void loginPageTest() {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        Assert.assertTrue(loginPage.isUserNameFieldPresent(), "UserName field is not present.");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present.");
        loginPage.typeUserName(R.TESTDATA.get("user_first"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button is not present.");
        CatalogScreenBase welcomeScreen = loginPage.clickLoginButton();
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");
    }


    // Second Test Case (Works)
    @Test
    public void filterTest() {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        loginPage.typeUserName(R.TESTDATA.get("user_first"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        CatalogScreenBase welcomeScreen = loginPage.clickLoginButton();
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");

        Assert.assertTrue(welcomeScreen.isFilterButtonPresent(), "Filter Button is not present.");
        FilterScreenBase filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isAToZButtonPresent(), "A to Z button is not present.");
        filterScreen.clickFilterOption(FilterOptions.FROMATOZ);

        filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isZToAButtonPresent(), "Z to A button is not present.");
        filterScreen.clickFilterOption(FilterOptions.FROMZTOA);

        filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isPriceLowerToHighButtonPresent(), "Lower to High button is not present.");
        filterScreen.clickFilterOption(FilterOptions.FROMLOWERTOHIGH);

        filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isPriceHigherToLowerButtonPresent(), "Higher to Lower button is not present.");
        filterScreen.clickFilterOption(FilterOptions.FROMHIGHERTOLOWER);
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");
    }


    // Third Test Case (Works)
    @Test
    public void productViewTest() {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        loginPage.typeUserName(R.TESTDATA.get("user_first"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        CatalogScreenBase welcomeScreen = loginPage.clickLoginButton();
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");

        Assert.assertTrue(welcomeScreen.isViewButtonPresent(), "View button is not present.");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                welcomeScreen.changeProductView(ProductViewOptions.GRID);
            } else {
                welcomeScreen.changeProductView(ProductViewOptions.LAYER);
            }
        }
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");
    }


    @Test
    public void productTest() {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        loginPage.typeUserName(R.TESTDATA.get("user_first"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        CatalogScreenBase welcomeScreen = loginPage.clickLoginButton();

        Set<String> stringSet = new HashSet<>();
        stringSet.add("Sauce Labs Backpack");
        stringSet.add("Sauce Labs Bike Light");
        stringSet.add("Sauce Labs Bolt T-Shirt");
        stringSet.add("Sauce Labs Fleece Jacket");
        stringSet.add("Sauce Labs Onesie");
        ProductScreenBase productPage;
        for (String x : stringSet) {
            productPage = welcomeScreen.clickProduct(x);
            Assert.assertTrue(productPage.isBackButtonPresent(), "Back button is not present.");
            welcomeScreen = productPage.clickBackButton();
        }
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product Bar is not present.");

    }

    @Test
    public void checkCartTest() {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        loginPage.typeUserName(R.TESTDATA.get("user_first"));
        loginPage.typePassword(R.TESTDATA.get("password"));
        CatalogScreenBase welcomeScreen = loginPage.clickLoginButton();

        ProductScreenBase productScreen = welcomeScreen.clickProduct(R.TESTDATA.get("third_product"));
        Assert.assertTrue(productScreen.isBackButtonPresent(), "Back button is not present.");
        productScreen.addToCart();
        Assert.assertTrue(productScreen.isClickCartButton(),"Cart button is not present.");
        productScreen.clickCartButton();
//        Assert.assertTrue(productScreen.isBackButtonPresent(), "Back button is not present.");
//        welcomeScreen = productScreen.clickBackButton();
//        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product Bar is not present.");
    }
}
