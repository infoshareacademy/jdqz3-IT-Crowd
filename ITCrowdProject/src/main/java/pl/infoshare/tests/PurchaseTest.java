package pl.infoshare.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.catrgories.PurchaseTests;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.*;

public class PurchaseTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
        this.user = new RegisteredUser(true);
    }

    @After
    public void closeBrowser() {
        basePage.close();
    }

    @Category(PurchaseTests.class)
    @Test
    public void purchase() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCatalouqePage handbagCatalouqePage = new HandbagCatalouqePage(driver);
        handbagCatalouqePage.addToCart();
        handbagCatalouqePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionFullName(user);
        checkoutPage.sectionCountryState(user);
        checkoutPage.submitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        Assert.assertNotNull("order is null", orderConfirmationPage.readOrderNumber());
    }
}
