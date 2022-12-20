import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CartScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CatalogScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductScreenBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.AuthService;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.FilterOptions;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.ProductViewOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class MobileTest implements IAbstractTest {

    // First Test Case (Works)
    @Test
    public void loginPageTest() {
        AuthService authService = new AuthService();
        CatalogScreenBase welcomeScreen = authService.login();
    }


    // Second Test Case (Works)
    @Test
    public void filterTest() {
        AuthService authService = new AuthService();
        CatalogScreenBase welcomeScreen = authService.login();

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
        AuthService authService = new AuthService();
        CatalogScreenBase welcomeScreen = authService.login();

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
        AuthService authService = new AuthService();
        CatalogScreenBase welcomeScreen = authService.login();

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
        AuthService authService = new AuthService();
        CatalogScreenBase welcomeScreen = authService.login();
        ProductScreenBase productScreen = welcomeScreen.clickProduct(R.TESTDATA.get("first_product"));
        Assert.assertTrue(productScreen.isBackButtonPresent(), "Back button is not present.");
        productScreen.addToCart();
        Assert.assertTrue(productScreen.isClickCartButton(),"Cart button is not present.");
        CartScreenBase cartScreen = productScreen.clickCartButton();
        Assert.assertTrue(cartScreen.isProductPresent(R.TESTDATA.get("first_product")));

    }
}
