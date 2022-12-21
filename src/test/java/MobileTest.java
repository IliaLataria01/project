import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.*;
import org.checkerframework.checker.units.qual.A;
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
        CartAdditionService cartAdditionService = new CartAdditionService();
        cartAdditionService.addProduct(R.TESTDATA.get("first_product"));
    }


    // Works
    @Test
    public void menuTest() {
        AuthService authService = new AuthService();
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(),"Menu click button is not present");
        MenuScreenBase menuScreen = catalogScreen.clickMenuButton();
        for (MenuOptions x : MenuOptions.values()) {
            Assert.assertTrue(menuScreen.checkMenuOption(x),"Options is not present.");
        }
        Assert.assertTrue(menuScreen.isCloseButtonPresent(),"Close button is not present.");
        menuScreen.clickCloseButton();
        Assert.assertTrue(catalogScreen.isProductBarPresent(), "Product Bar is not present.");
    }

    // Works
    @Test
    public void logOutTest() {
        MenuService menuService = new MenuService();
        MenuScreenBase menuScreen = menuService.menuService();
        Assert.assertTrue(menuScreen.checkMenuOption(MenuOptions.LOGOUT),"Log out option is present.");
        LoginScreenBase loginScreenBase = menuScreen.clickLogOutButton();
        Assert.assertTrue(loginScreenBase.isLoginButtonPresent(),"Login button is not present. ");
    }

    // Works
    @Test
    public void webViewTest() throws InterruptedException {
        AuthService authService = new AuthService();
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(),"Menu click button is not present");
        MenuScreenBase menuScreen = catalogScreen.clickMenuButton();
        Assert.assertTrue(menuScreen.checkMenuOption(MenuOptions.WEBVIEW),"Web view option is not present.");
        WebViewScreenBase webViewScreen = menuScreen.clickWebViewButton();
        Assert.assertTrue(webViewScreen.isURLFieldPresent(),"URL field is not present.");
        webViewScreen.typeURL(R.TESTDATA.get("url"));
        Assert.assertTrue(webViewScreen.isGoToButtonPresent(),"Go to site button is not present.");
        webViewScreen.clickGoToSiteButton();
        Thread.sleep(5000);
    }

    // Works (But When I find drawing functionality will modify it)
    @Test
    public void signatureTest() {
        AuthService authService = new AuthService();
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(),"Menu click button is not present");
        MenuScreenBase menuScreen = catalogScreen.clickMenuButton();

        Assert.assertTrue(menuScreen.checkMenuOption(MenuOptions.DRAWING),"Drawing option is not present.");
        DrawScreenBase drawScreen = menuScreen.clickDrawingButton();

        Assert.assertTrue(drawScreen.isSaveButtonPresent(),"Save button is not present.");
        drawScreen.clickSaveButton();

        menuScreen = catalogScreen.clickMenuButton();
        Assert.assertTrue(menuScreen.checkMenuOption(MenuOptions.ALLITEMS),"All items options is not present.");
        catalogScreen = menuScreen.clickAllItemsButton();
        Assert.assertTrue(catalogScreen.isProductBarPresent(),"Product bar is not present.");
    }

    // Works
    @Test
    public void locationTest() {
        MenuService menuService = new MenuService();
        MenuScreenBase menuScreen = menuService.menuService();

        Assert.assertTrue(menuScreen.checkMenuOption(MenuOptions.GEOLOCATION),"Location Option is not present.");
        LocationScreenBase locationScreen = menuScreen.clickLocationButton();

        Assert.assertTrue(locationScreen.isAllowButtonPresent(),"Allow button is not present.");
        locationScreen.clickAllowButton();

        Assert.assertTrue(locationScreen.isLocationBarPresent(),"Location bar is not present.");
    }

    // Works
    @Test
    public void checkOutTest() {
        CartAdditionService cartAdditionService = new CartAdditionService();
        CartScreenBase cartScreen = cartAdditionService.addProduct(R.TESTDATA.get("first_product"));

        Assert.assertTrue(cartScreen.isCheckoutButtonPresent(),"Checkout button is not present.");
        CheckoutScreenBase checkoutScreen = cartScreen.clickCheckoutButton();

        Assert.assertTrue(checkoutScreen.isFirstNameFieldPresent(),"First name field is not present.");
        checkoutScreen.typeFirstName(R.TESTDATA.get("first_name"));
        Assert.assertTrue(checkoutScreen.isLastNameFieldPresent(),"Last name field is not present.");
        checkoutScreen.typeLastName(R.TESTDATA.get("last_name"));
        Assert.assertTrue(checkoutScreen.isPostalCodeFieldPresent(),"Postal code field is not present.");
        checkoutScreen.typePostalCode(R.TESTDATA.get("postal_code"));
        Assert.assertTrue(checkoutScreen.isContinueButtonPresent(),"Continue button is not present.");

        ConfirmScreenBase confirmScreen = checkoutScreen.clickContinueButton();
        confirmScreen.clickFinishButton();
        Assert.assertTrue(confirmScreen.isGoBackButtonPresent(),"Go back button is not present.");
        CatalogScreenBase catalogScreen = confirmScreen.clickGoBackButton();
        Assert.assertTrue(catalogScreen.isProductBarPresent(),"Product bar is not present.");
    }

    @Test
    public void removalTest() {
        CartAdditionService cartAdditionService = new CartAdditionService();
        CartScreenBase cartScreen = cartAdditionService.addProduct(R.TESTDATA.get("first_product"));

        Assert.assertTrue(cartScreen.isContinueShoppingButtonPresent(),"Continue shopping button is not present.");
        CatalogScreenBase catalogScreen = cartScreen.clickContinueShoppingButton();
        Assert.assertTrue(catalogScreen.isRemovalButtonPresent(R.TESTDATA.get("first_product")));
        catalogScreen.clickRemovalButton(R.TESTDATA.get("first_product"));
        Assert.assertTrue(catalogScreen.isProductBarPresent(),"Product bar is not present.");
    }

    @Test
    public void scannerTest() {
        MenuService menuService = new MenuService();
        MenuScreenBase menuScreen = menuService.menuService();
        Assert.assertTrue(menuScreen.checkMenuOption(MenuOptions.QRCODESCANNER),"QR option is not present.");
        ScannerScreenBase scannerScreen = menuScreen.clickScannerButton();

        Assert.assertTrue(scannerScreen.isOkButtonPresent(),"Ok button is not present.");
        scannerScreen.clickOkButton();
        Assert.assertTrue(scannerScreen.isQRCodeRepresentationPresent(),"QR code representation is not present.");
    }

    @Test
    public void aboutTest() {
        MenuService menuService = new MenuService();
        MenuScreenBase menuScreen = menuService.menuService();
        Assert.assertTrue(menuScreen.checkMenuOption(MenuOptions.ABOUT),"About option is not present.");
        AboutScreenBase aboutScreen = menuScreen.clickAboutButton();
        Assert.assertTrue(aboutScreen.isHomeButtonPresent(),"Home button is not present.");
        Assert.assertTrue(aboutScreen.isMenuButtonPresent(),"Menu button is not present.");
    }

    @Test
    public void aboutScreenMenuTest() {
        MenuService menuService = new MenuService();
        MenuScreenBase menuScreen = menuService.menuService();
        AboutScreenBase aboutScreen = menuScreen.clickAboutButton();
        Assert.assertTrue(aboutScreen.isMenuButtonPresent(),"Menu button is not present.");
        MenuAboutScreenBase menuAboutScreen = aboutScreen.clickMenuButton();
        Assert.assertTrue(menuAboutScreen.isCloseButtonPresent(),"Close button is not present.");
        menuAboutScreen.clickCloseButton();
        Assert.assertTrue(aboutScreen.isHomeButtonPresent(),"Home button is not present.");
    }
}
