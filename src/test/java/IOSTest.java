import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.FilterPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.ProductPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSTest implements IAbstractTest {

    // First Test Case (Works)
    @Test
    public void loginPageTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isUserNameFieldPresent(), "UserName field is not present.");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_third"));
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button is not present.");
        WelcomePageBase welcomePageBase = loginPage.clickLoginButton();
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product bar is not present.");
    }


    // Second Test Case (Works)
    @Test
    public void filterTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isUserNameFieldPresent(), "UserName field is not present.");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_third"));
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button is not present.");
        WelcomePageBase welcomePageBase = loginPage.clickLoginButton();
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product bar is not present.");

        Assert.assertTrue(welcomePageBase.isFilterButtonPresent(), "Filter Button is not present.");
        FilterPageBase filterPageBase = welcomePageBase.clickFilterButton();
        Assert.assertTrue(filterPageBase.isAToZButtonPresent(), "A to Z button is not present.");
        filterPageBase.filterAToZ();

        filterPageBase = welcomePageBase.clickFilterButton();
        Assert.assertTrue(filterPageBase.isZToAButtonPresent(), "Z to A button is not present.");
        filterPageBase.filterZToA();

        filterPageBase = welcomePageBase.clickFilterButton();
        Assert.assertTrue(filterPageBase.isPriceLowerToHighButtonPresent(), "Lower to High button is not present.");
        filterPageBase.filterPriceLowerToHigh();

        filterPageBase = welcomePageBase.clickFilterButton();
        Assert.assertTrue(filterPageBase.isPriceHigherToLowerButtonPresent(), "Higher to Lower button is not present.");
        filterPageBase.filterPriceHighToLower();
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product bar is not present.");
    }


    // Third Test Case (Works)
    @Test
    public void productViewTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isUserNameFieldPresent(), "UserName field is not present.");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_third"));
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button is not present.");
        WelcomePageBase welcomePageBase = loginPage.clickLoginButton();
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product bar is not present.");

        Assert.assertTrue(welcomePageBase.isViewButtonPresent(), "View button is not present.");
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                welcomePageBase.changeProductView(R.TESTDATA.get("grid"));
            } else {
                welcomePageBase.changeProductView(R.TESTDATA.get("layer"));
            }
        }
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product bar is not present.");
    }


    @Test
    public void productTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isUserNameFieldPresent(), "UserName field is not present.");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_first"));
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button is not present.");
        WelcomePageBase welcomePageBase = loginPage.clickLoginButton();
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product bar is not present.");

        ProductPageBase productPageBase = welcomePageBase.clickProduct(R.TESTDATA.get("first_product"));
        Assert.assertTrue(productPageBase.isBackButtonPresent(), "Back button is not present.");
        welcomePageBase = productPageBase.clickBackButton();

        productPageBase = welcomePageBase.clickProduct(R.TESTDATA.get("second_product"));
        Assert.assertTrue(productPageBase.isBackButtonPresent(), "Back button is not present.");
        welcomePageBase = productPageBase.clickBackButton();

        productPageBase = welcomePageBase.clickProduct(R.TESTDATA.get("third_product"));
        Assert.assertTrue(productPageBase.isBackButtonPresent(), "Back button is not present.");
        welcomePageBase = productPageBase.clickBackButton();

        productPageBase = welcomePageBase.clickProduct(R.TESTDATA.get("fourth_product"));
        Assert.assertTrue(productPageBase.isBackButtonPresent(), "Back button is not present.");
        welcomePageBase = productPageBase.clickBackButton();

        productPageBase = welcomePageBase.clickProduct(R.TESTDATA.get("fifth_product"));
        Assert.assertTrue(productPageBase.isBackButtonPresent(), "Back button is not present.");
        welcomePageBase = productPageBase.clickBackButton();

        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product Bar is not present.");

    }

    @Test
    public void checkCartTest() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isUserNameFieldPresent(), "UserName field is not present.");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_first"));
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Login button is not present.");
        WelcomePageBase welcomePageBase = loginPage.clickLoginButton();
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product bar is not present.");

        ProductPageBase productPageBase = welcomePageBase.clickProduct(R.TESTDATA.get("third_product"));
        Assert.assertTrue(productPageBase.isBackButtonPresent(), "Back button is not present.");
        productPageBase.addToCart();
        Assert.assertTrue(productPageBase.isBackButtonPresent(), "Back button is not present.");
        welcomePageBase = productPageBase.clickBackButton();
        Assert.assertTrue(welcomePageBase.isProductBarPresent(), "Product Bar is not present.");
    }
}
