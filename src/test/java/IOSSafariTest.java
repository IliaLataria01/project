import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.webtest.common.enums.Category;
import com.qaprosoft.carina.demo.gui.webtest.common.enums.NavigationLinks;
import com.qaprosoft.carina.demo.gui.webtest.common.util.UserFactory;
import com.qaprosoft.carina.demo.gui.webtest.ios.components.CategoryComponent;
import com.qaprosoft.carina.demo.gui.webtest.ios.page.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSSafariTest implements IAbstractTest, IMobileUtils {

    // IOS Works,
    @Test
    public void loginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LoginPage loginPage = (LoginPage) homePage.getMenuComponent().openPage(NavigationLinks.LOGIN);
        Assert.assertTrue(loginPage.isLoginFormPresent(), "Login Form was not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(), "UserName Field was not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(), "Password Field was not present.");
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Log in button was not present.");
        // This test one for already Registered
        loginPage.inputLogin(R.TESTDATA.get("user_name"), R.TESTDATA.get("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getMenuComponent().isWelcomeMessagePresent(R.TESTDATA.get("user_name")), "" +
                "Appropriate welcome message is not present.");
    }

    // IOS Works,
    @Test
    public void contactTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        ContactPage contactPage = (ContactPage) homePage.getMenuComponent().openPage(NavigationLinks.CONTACT);
        Assert.assertTrue(contactPage.isContactNameFieldPresent(), "Name Field is not present.");
        Assert.assertTrue(contactPage.isEmailFieldPresent(), "Email Field is not present.");
        Assert.assertTrue(contactPage.isMessageAreaPresent(), "Message Area is not present.");
        contactPage.newMessage(R.TESTDATA.get("email"), R.TESTDATA.get("contact_name"), R.TESTDATA.get("message"));
        Assert.assertTrue(contactPage.isSendMessageButtonPresent(), "Send Message Button is not present");
        contactPage.clickSendMessageButton();
        Assert.assertTrue(contactPage.isCloseButtonPresent(), "Close button is not present.");
        contactPage.clickCloseButton();
        Assert.assertTrue(homePage.isNextPageButtonPresent(), "NextPage button is not present.");
    }

    // IOS Works,
    @Test
    public void checkLogOut() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        LoginPage loginPage = (LoginPage) homePage.getMenuComponent().openPage(NavigationLinks.LOGIN);
        Assert.assertTrue(loginPage.isLoginFormPresent(), "Login Form was not present.");
        Assert.assertTrue(loginPage.isLoginUserNameFieldPresent(), "UserName Field was not present.");
        Assert.assertTrue(loginPage.isLoginPasswordFieldPresent(), "Password Field was not present.");
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Log in button was not present.");
        loginPage.inputLogin(R.TESTDATA.get("user_name"), R.TESTDATA.get("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getMenuComponent().isLinkPresent(NavigationLinks.LOGOUT), "Log out button was not present.");
        homePage.getMenuComponent().clickLogOutButton();
        Assert.assertFalse(homePage.getMenuComponent().isLinkPresent(NavigationLinks.LOGOUT), "Log out Button is still present.");
    }

    // IOS Works,
    @Test
    public void signUpTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        SignUpPage signUpPage = (SignUpPage) homePage.getMenuComponent().openPage(NavigationLinks.SIGNIN);
        Assert.assertTrue(signUpPage.isSignUpFormPresent(), "Sign up form was not present.");
        Assert.assertTrue(signUpPage.isSignUpUserNameFieldPresent(), "UserName field was not present.");
        Assert.assertTrue(signUpPage.isSignUpPasswordFieldPresent(), "Password field was not present.");
        signUpPage.inputSignUp(UserFactory.getRandomUserName(), UserFactory.getRandomPassword());
        Assert.assertTrue(homePage.getMenuComponent().isLinkPresent(NavigationLinks.SIGNIN), "Sign up button was not present.");
        signUpPage.clickSignUpButton();
        Assert.assertTrue(signUpPage.isCloseButtonPresent(), "Close button is not present.");
        signUpPage.clickCloseButton();
        Assert.assertTrue(homePage.getMenuComponent().isLinkPresent(NavigationLinks.LOGIN), "Login button was not present.");
    }

    // IOS Works,
    @Test
    public void categoryTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        CategoryComponent categoryComponent = homePage.getCategoryComponent();
        Assert.assertTrue(categoryComponent.isCategoryPresent(Category.MONITORS), "Monitors category is not present.");
        categoryComponent.switchCategory(Category.MONITORS);
        Assert.assertTrue(categoryComponent.isCategoryPresent(Category.PHONES), "Phones category is not present.");
        categoryComponent.switchCategory(Category.PHONES);
        Assert.assertTrue(categoryComponent.isCategoryPresent(Category.LAPTOPS), "Laptops category is not present.");
        categoryComponent.switchCategory(Category.LAPTOPS);
        Assert.assertTrue(categoryComponent.isCategoryPresent(Category.MIX), "Mix Categories is not present.");
    }

    // IOS Works,
    @Test
    public void aboutTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        AboutPage aboutPage = (AboutPage) homePage.getMenuComponent().openPage(NavigationLinks.ABOUT_US);
        Assert.assertTrue(aboutPage.isVideoPresent(), "Video is not present");
//        aboutPage.playVideo(10000); // If you want to play a video
        Assert.assertTrue(aboutPage.isCloseButtonPresent(), "Close button is not present");
        aboutPage.clickCloseButton();
        Assert.assertTrue(homePage.getMenuComponent().isLinkPresent(NavigationLinks.LOGIN), "Log in link is not present.");
    }

    // IOS Works,
    @Test
    public void additionOfProductInTheCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        ProductPage productPage = homePage.getProductComponent().clickProduct((R.TESTDATA.get("productName")));
        productPage.addToCartProduct();
        Assert.assertTrue(productPage.isCloseButtonPresent(), "Close button is not present.");
        productPage.clickCloseButton();
        CartPage cartPage = (CartPage) homePage.getMenuComponent().openPage(NavigationLinks.CART);
        ContactPage page = (ContactPage) cartPage.getTopBarMenu().openPage(NavigationLinks.CONTACT);
        Assert.assertTrue(page.isSendMessageButtonPresent(), "Message button is not opened.");
    }

    // IOS NOT WORKS
    @Test
    public void removalFromCartTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        ProductPage productPage = homePage.getProductComponent().clickProduct((R.TESTDATA.get("productName")));
        productPage.addToCartProduct();
        Assert.assertTrue(productPage.isCloseButtonPresent(), "Close button is not present.");
        productPage.clickCloseButton();
        CartPage cartPage = (CartPage) homePage.getMenuComponent().openPage(NavigationLinks.CART);
        cartPage.removeProductFromCart(R.TESTDATA.get("productName"));
        Assert.assertFalse(cartPage.isProductPresent(R.TESTDATA.get("productName")), "Product was not deleted.");
    }

    // IOS Works,
    @Test
    public void orderTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.openURL("https://demoblaze.com/");
        ProductPage productPage = homePage.getProductComponent().clickProduct((R.TESTDATA.get("productName")));
        productPage.addToCartProduct();
        Assert.assertTrue(productPage.isCloseButtonPresent(), "Close button is not present.");
        productPage.clickCloseButton();
        CartPage cartPage = (CartPage) homePage.getMenuComponent().openPage(NavigationLinks.CART);
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
        ConfirmationPage confirmationPage = orderPage.clickPurchaseButton();
        Assert.assertTrue(confirmationPage.isConfirmButtonPresent(), "Confirm button was not present.");
        confirmationPage.clickConfirmButton();
        Assert.assertTrue(homePage.getMenuComponent().isLinkPresent(NavigationLinks.LOGIN), "Login link is not present.");
    }

}
