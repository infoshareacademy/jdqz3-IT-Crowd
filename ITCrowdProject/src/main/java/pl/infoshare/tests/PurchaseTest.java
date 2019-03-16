package pl.infoshare.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.catrgories.AddToCartRandomBagTest;
import pl.infoshare.catrgories.AddToCartTests;
import pl.infoshare.catrgories.PurchaseTests;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Bag;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.generators.BagGenerator;
import pl.infoshare.pages.*;
import pl.infoshare.pages.components.CategoriesMenu;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;
    private Bag randomBag;
    private Bag randomBagNext;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
        this.user = new RegisteredUser(true);
        this.randomBag = BagGenerator.generateRandomBag();
        this.randomBagNext = BagGenerator.generateRandomBag();
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

    @Category(AddToCartRandomBagTest.class)
    @Test
    public void addToCartRandomBag() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseCategory(randomBag.getCategory());

        CategoriesMenu categoriesMenu = new CategoriesMenu();
        CatalouqePage catalouqePage = new CatalouqePage(driver, categoriesMenu.switchToPage(randomBag.getCategory()));
        catalouqePage.getRandomBag(randomBag.getName());
        catalouqePage.addToCart();
        catalouqePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        assertThat(reviewYourOrderPage.getItem().getText()).isEqualTo(randomBag.getName());
        assertThat(reviewYourOrderPage.getQuantity().getValue()).isEqualTo("1");
        assertThat(Double.parseDouble(reviewYourOrderPage.getPrice().getText().substring(1))).isEqualTo(randomBag.getPrice().doubleValue());
        assertThat(Double.parseDouble(reviewYourOrderPage.getTotal().getText().substring(1))).isEqualTo(randomBag.getPrice().doubleValue());
    }

    @Test
    public void addToCartNextRandomBag() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseCategory(randomBag.getCategory());

        CategoriesMenu categoriesMenu = new CategoriesMenu();
        System.out.println(randomBag.getCategory());
        System.out.println(categoriesMenu.switchToPage(randomBag.getCategory()));
        System.out.println(randomBag.getName());
        System.out.println(randomBag.toString());

        CatalouqePage catalouqePage = new CatalouqePage(driver, categoriesMenu.switchToPage(randomBag.getCategory()));
        catalouqePage.getRandomBag(randomBag.getName());
        catalouqePage.addToCart();
  //    catalouqePage.checkout();

        mainPage.chooseCategory(randomBagNext.getCategory());
        System.out.println(randomBagNext.getCategory());
        System.out.println(categoriesMenu.switchToPage(randomBagNext.getCategory()));
        System.out.println(randomBagNext.getName());
        System.out.println(randomBagNext.toString());

        CatalouqePage catalouqePageNext = new CatalouqePage(driver, categoriesMenu.switchToPage(randomBagNext.getCategory()));
        catalouqePageNext.getRandomBag(randomBagNext.getName());
        catalouqePageNext.addToCart();
        catalouqePageNext.checkout();

//        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
//        assertThat(reviewYourOrderPage.getItem().getText()).isEqualTo(randomBag.getName());
//        assertThat(reviewYourOrderPage.getQuantity().getValue()).isEqualTo("1");
//        assertThat(Double.parseDouble(reviewYourOrderPage.getPrice().getText().substring(1))).isEqualTo(randomBag.getPrice().doubleValue());
//        assertThat(Double.parseDouble(reviewYourOrderPage.getTotal().getText().substring(1))).isEqualTo(randomBag.getPrice().doubleValue());
    }

}
