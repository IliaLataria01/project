import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.modals.LocationPermissionsAlertBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.modals.SignaturePermissionsAlertBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class MobileTest extends SwagLabAbstractTest implements IAbstractTest {

    // Works
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


    // Works
    @Test
    public void filterTest() {
        CatalogScreenBase welcomeScreen = authService.login();

        Assert.assertTrue(welcomeScreen.isFilterButtonPresent(), "Filter Button is not present.");
        FilterScreenBase filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isFilterPresent(FilterOption.FROM_A_TO_Z), "A to Z button is not present.");
        filterScreen.clickFilterOption(FilterOption.FROM_A_TO_Z);

        filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isFilterPresent(FilterOption.FROM_Z_TO_A), "Z to A button is not present.");
        filterScreen.clickFilterOption(FilterOption.FROM_Z_TO_A);

        filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isFilterPresent(FilterOption.FROM_LOWER_TO_HIGH), "Lower to High button is not present.");
        filterScreen.clickFilterOption(FilterOption.FROM_LOWER_TO_HIGH);

        filterScreen = welcomeScreen.clickFilterButton();
        Assert.assertTrue(filterScreen.isFilterPresent(FilterOption.FROM_HIGHER_TO_LOWER), "Higher to Lower button is not present.");
        filterScreen.clickFilterOption(FilterOption.FROM_HIGHER_TO_LOWER);
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");
    }


    // Works
    @Test
    public void productViewTest() {
        CatalogScreenBase welcomeScreen = authService.login();
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                Assert.assertTrue(welcomeScreen.isViewButtonPresent(), "View button with grid view is not present.");
                welcomeScreen.changeProductView(ProductViewOptions.GRID);
            } else {
                Assert.assertTrue(welcomeScreen.isViewButtonPresent(), "View button with layer view is not present.");
                welcomeScreen.changeProductView(ProductViewOptions.LAYER);
            }
        }
        Assert.assertTrue(welcomeScreen.isProductBarPresent(), "Product bar is not present.");
    }

    // Works
    @Test
    public void productTest() {
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

    // Works
    @Test
    public void checkCartTest() {
        AuthService authService = new AuthService();
        CatalogScreenBase welcomeScreen = authService.login();
        ProductScreenBase productScreen = welcomeScreen.clickProduct(R.TESTDATA.get("first_product"));
        Assert.assertTrue(productScreen.isBackButtonPresent(), "Back button is not present.");
        productScreen.clickAddToCartButton();
        Assert.assertTrue(productScreen.isCartButtonPresent(), "Cart button is not present.");
        CartScreenBase cartScreen = productScreen.clickCartButton();
        Assert.assertTrue(cartScreen.isProductPresent(R.TESTDATA.get("first_product")));
    }


    // Works
    @Test
    public void menuTest() {
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(), "Menu click button is not present");
        MenuScreenBase menuScreen = catalogScreen.clickMenuButton();
        for (MenuOption x : MenuOption.values()) {
            Assert.assertTrue(menuScreen.checkMenuOption(x), "Options is not present.");
        }
        Assert.assertTrue(menuScreen.isCloseButtonPresent(), "Close button is not present.");
        menuScreen.clickCloseButton();
        Assert.assertTrue(catalogScreen.isProductBarPresent(), "Product Bar is not present.");
    }

    // Works
    @Test
    public void logOutTest() {
        LoginScreenBase loginScreenBase = (LoginScreenBase) menuService.open(MenuOption.LOGOUT);
        Assert.assertTrue(loginScreenBase.isLoginButtonPresent(), "Login button is not present. ");
    }

    // Works
    @Test
    public void webViewTest() {
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(), "Menu click button is not present");
        MenuScreenBase menuScreen = catalogScreen.clickMenuButton();
        Assert.assertTrue(menuScreen.checkMenuOption(MenuOption.WEBVIEW), "Web view option is not present.");
        OpenWebViewScreenBase webViewScreen = (OpenWebViewScreenBase) menuScreen.clickMenuOption(MenuOption.WEBVIEW);
        Assert.assertTrue(webViewScreen.isURLFieldPresent(), "URL field is not present.");
        webViewScreen.typeURL(R.TESTDATA.get("url"));
        Assert.assertTrue(webViewScreen.isGoToButtonPresent(), "Go to site button is not present.");
        WebViewScreenBase randomScreen = webViewScreen.clickGoToSiteButton();
        Assert.assertTrue(randomScreen.isLogoPresent(), "Page is not opened.");
    }

    // Works
    @Test
    public void signatureTest() {
        CatalogScreenBase catalogScreen = authService.login();
        Assert.assertTrue(catalogScreen.isMenuClickButtonPresent(), "Menu click button is not present");
        MenuScreenBase menuScreen = catalogScreen.clickMenuButton();

        Assert.assertTrue(menuScreen.checkMenuOption(MenuOption.DRAWING), "Drawing option is not present.");
        DrawScreenBase drawScreen = (DrawScreenBase) menuScreen.clickMenuOption(MenuOption.DRAWING);


        Assert.assertTrue(drawScreen.isDrawContainerPresent(), "Draw container is not present.");
        Assert.assertTrue(drawScreen.draw(), "Draw did not happend.");


        Assert.assertTrue(drawScreen.isSaveButtonPresent(), "Save button is not present.");
        SignaturePermissionsAlertBase signaturePermissionsAlert = drawScreen.clickSaveButton();
        Assert.assertTrue(signaturePermissionsAlert.isDoNotAllowButtonPresent(), "Do not allow button is not present.");
        signaturePermissionsAlert.clickDoNotAllowButton();

        Assert.assertTrue(signaturePermissionsAlert.isOkButtonPresent(), "Ok button is not present.");
        signaturePermissionsAlert.clickOkButton();

        menuScreen = catalogScreen.clickMenuButton();
        Assert.assertTrue(menuScreen.checkMenuOption(MenuOption.ALLITEMS), "All items options is not present.");
        catalogScreen = (CatalogScreenBase) menuScreen.clickMenuOption(MenuOption.ALLITEMS);
        Assert.assertTrue(catalogScreen.isProductBarPresent(), "Product bar is not present.");
    }

    // Works
    @Test
    public void locationTest() {
        LocationPermissionsAlertBase locationPermissionsAlert = (LocationPermissionsAlertBase) menuService.open(MenuOption.GEOLOCATION);
        Assert.assertTrue(locationPermissionsAlert.isAllowButtonPresent(), "Allow button is not present.");
        LocationScreenBase locationScreen = locationPermissionsAlert.clickAllowButton();
        Assert.assertTrue(locationScreen.isLocationBarPresent(), "Location bar is not present.");
    }

    // Works
    @Test
    public void checkOutTest() {
        CartScreenBase cartScreen = cartAdditionService.addProduct(R.TESTDATA.get("first_product"));

        Assert.assertTrue(cartScreen.isCheckoutButtonPresent(), "Checkout button is not present.");
        CheckoutScreenBase checkoutScreen = cartScreen.clickCheckoutButton();

        Assert.assertTrue(checkoutScreen.isFirstNameFieldPresent(), "First name field is not present.");
        checkoutScreen.typeFirstName(R.TESTDATA.get("first_name"));
        Assert.assertTrue(checkoutScreen.isLastNameFieldPresent(), "Last name field is not present.");
        checkoutScreen.typeLastName(R.TESTDATA.get("last_name"));
        Assert.assertTrue(checkoutScreen.isPostalCodeFieldPresent(), "Postal code field is not present.");
        checkoutScreen.typePostalCode(R.TESTDATA.get("postal_code"));
        Assert.assertTrue(checkoutScreen.isContinueButtonPresent(), "Continue button is not present.");

        ConfirmScreenBase confirmScreen = checkoutScreen.clickContinueButton();
        confirmScreen.clickFinishButton();
        Assert.assertTrue(confirmScreen.isOrderAcceptanceText(), "Order Acceptance Text is not presnt.");
        Assert.assertTrue(confirmScreen.isGoBackButtonPresent(), "Go back button is not present.");
        CatalogScreenBase catalogScreen = confirmScreen.clickGoBackButton();
        Assert.assertTrue(catalogScreen.isProductBarPresent(), "Product bar is not present.");
    }


    // Works
    @Test
    public void removeItemFromCartTest() {
        CartScreenBase cartScreen = cartAdditionService.addProduct(R.TESTDATA.get("first_product"));
        Assert.assertTrue(cartScreen.isContinueShoppingButtonPresent(), "Continue shopping button is not present.");
        CatalogScreenBase catalogScreen = cartScreen.clickContinueShoppingButton();
        Assert.assertTrue(catalogScreen.isRemovalButtonPresent(R.TESTDATA.get("first_product")));
        catalogScreen.clickRemovalButton(R.TESTDATA.get("first_product"));
        Assert.assertTrue(catalogScreen.isProductBarPresent(), "Product bar is not present.");
        cartScreen = catalogScreen.clickCartButton();
        Assert.assertFalse(cartScreen.isProductPresent(R.TESTDATA.get("first_product")), "Element is not removed");
    }


    // Works
    @Test
    public void scannerTest() {
        ScannerScreenBase scannerScreen = (ScannerScreenBase) menuService.open(MenuOption.QRCODESCANNER);
        Assert.assertTrue(scannerScreen.isOkButtonPresent(), "Ok button is not present.");
        scannerScreen.clickOkButton();
        Assert.assertTrue(scannerScreen.isQRCodeRepresentationPresent(), "QR code representation is not present.");
    }

    // Works
    @Test
    public void aboutTest() {
        AboutScreenBase aboutScreen = (AboutScreenBase) menuService.open(MenuOption.ABOUT);
        Assert.assertTrue(aboutScreen.isHomeButtonPresent(), "Home button is not present.");
        Assert.assertTrue(aboutScreen.isMenuButtonPresent(), "Menu button is not present.");
    }

    // Works
    @Test
    public void aboutScreenMenuTest() {
        AboutScreenBase aboutScreen = (AboutScreenBase) menuService.open(MenuOption.ABOUT);
        Assert.assertTrue(aboutScreen.isMenuButtonPresent(), "Menu button is not present.");
        SafariBrowserBase safariBrowser = aboutScreen.clickMenuButton();
        Assert.assertTrue(safariBrowser.isCloseButtonPresent(), "Close button is not present.");
        safariBrowser.clickCloseButton();
        Assert.assertTrue(aboutScreen.isHomeButtonPresent(), "Home button is not present.");

    }

    // Comment Added

    public void justRandomMethodForChange() {
    }

    public void anotherRandom() {
    }

    public void luckyRandomMethod() {
    }
}
