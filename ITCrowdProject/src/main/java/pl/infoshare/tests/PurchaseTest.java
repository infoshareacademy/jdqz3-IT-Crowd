package pl.infoshare.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.categories.*;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Bag;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.generators.BagGenerator;
import pl.infoshare.pages.*;
import pl.infoshare.pages.components.CategoriesMenu;
import static org.assertj.core.api.Assertions.*;


public class PurchaseTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;
    private Bag randomBag;
    private Bag randomBagNext;
    private Bag randomLaptopBag;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
        this.user = new RegisteredUser(true);
        this.randomBag = BagGenerator.generateRandomBag();
        this.randomBagNext = BagGenerator.generateRandomBag();
        this.randomLaptopBag = BagGenerator.generateCategoryRandomBag("Laptop bags");
    }

    @After
    public void closeBrowser() {
        basePage.close();
    }

    @Category(pl.infoshare.categories.PurchaseTest.class)
    @Test
    public void purchase() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionFullName(user);
        checkoutPage.fillInSectionCountryState(user);
        checkoutPage.submitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        assertThat(orderConfirmationPage.readOrderCompleted()).isEqualTo("Order completed");
    }

        @Category(AddToCartTest.class)
        @Test
        public void addToCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.checkout();

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

    @Category(AddToCartNextRandomBagTest.class)
    @Test
    public void addToCartNextRandomBag() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseCategory(randomBag.getCategory());

        CategoriesMenu categoriesMenu = new CategoriesMenu();

        CatalouqePage catalouqePage = new CatalouqePage(driver, categoriesMenu.switchToPage(randomBag.getCategory()));
        catalouqePage.getRandomBag(randomBag.getName());
        catalouqePage.addToCart();

        MainPage mainPageNext = new MainPage(driver);
        mainPageNext.chooseCategory(randomBagNext.getCategory());
        CatalouqePage catalouqePageNext = new CatalouqePage(driver, categoriesMenu.switchToPage(randomBagNext.getCategory()));
        catalouqePageNext.getRandomBag(randomBagNext.getName());
        catalouqePageNext.addToCart();
        catalouqePageNext.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        assertThat(Double.parseDouble(reviewYourOrderPage.getTotalsSubtotal().getText().substring(1)))
                .isEqualTo(randomBag.getPrice().doubleValue() + randomBagNext.getPrice().doubleValue() );
        assertThat(Double.parseDouble(reviewYourOrderPage.getTotalsTotal().getText().substring(1)))
                .isEqualTo(randomBag.getPrice().doubleValue() + randomBagNext.getPrice().doubleValue());
    }

    @Category(PurchaseLaptopBagTest.class)
    @Test
    public void purchaseLaptopBag() {

        MainPage mainPage = new MainPage(driver);
        mainPage.chooseCategory(randomLaptopBag.getCategory());

        LaptopBagsCataloguePage laptopBagsCataloguePage = new LaptopBagsCataloguePage(driver);
        laptopBagsCataloguePage.getRandomBag(randomLaptopBag.getName());
        laptopBagsCataloguePage.addToCart();
        laptopBagsCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionFullName(user);
        checkoutPage.fillInSectionCountryState(user);
        checkoutPage.submitOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        assertThat(orderConfirmationPage.readOrderCompleted()).isEqualTo("Order completed");
    }
}
