package pl.infoshare.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.catrgories.AddToCartTests;
import pl.infoshare.catrgories.PurchaseTests;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Bag;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.*;
import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;
    private Bag bag;

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

        @Category(AddToCartTests.class)
        @Test
        public void addToCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCatalouqePage handbagCatalouqePage = new HandbagCatalouqePage(driver);
        handbagCatalouqePage.addToCart();
        handbagCatalouqePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        assertThat(reviewYourOrderPage.getItem().getText()).isEqualTo("Chic vintage DeVille");
        assertThat(reviewYourOrderPage.getQuantity().getValue()).isEqualTo("1");
        assertThat(reviewYourOrderPage.getPrice().getText()).isEqualTo("$78.00");
        assertThat(reviewYourOrderPage.getTotal().getText()).isEqualTo("$78.00");
    }
}
