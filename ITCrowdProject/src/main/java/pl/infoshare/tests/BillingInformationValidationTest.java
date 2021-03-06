package pl.infoshare.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.categories.*;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Bag;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.generators.BagGenerator;
import pl.infoshare.pages.*;



import static org.assertj.core.api.Assertions.assertThat;

public class BillingInformationValidationTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;
    private Bag randomBag;
    private Bag randomBagNext;
    private Bag randomLaptopBag;

    @Rule
    public TestName testName = new TestName();
    @Before
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
        this.user = new RegisteredUser(true);
        this.randomBag = BagGenerator.generateRandomBag();
        this.randomBagNext = BagGenerator.generateRandomBag();
        this.randomLaptopBag = BagGenerator.generateCategoryRandomBag("Laptop bags");
    }

    @After
    public void closeBrowser() {
        basePage.screenShoot(testName.getMethodName());
        basePage.close();
    }

    @Category(ValidateNameIsRequired.class)
    @Test
    public void validateNameIsEmpty() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertThat(checkoutPage.validateResult()).isEqualTo("First name is required");
    }
    @Category(ValidateLastnameIsRequired.class)
    @Test
    public void validateLastnameIsEmpty() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionName(user);
        assertThat(checkoutPage.validateResult()).isEqualTo("Last name is required");
    }

    @Category(ValidateStreetAddressIsRequired.class)
    @Test
    public void validateStreetAddressIsEmpty() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionName(user);
        checkoutPage.sectionLastName(user);
        assertThat(checkoutPage.validateResult()).isEqualTo("Street address is required");
    }


    @Category(ValidateStateIsRequired.class)
    @Test
    public void validateStateIsEmpty() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionName(user);
        checkoutPage.sectionLastName(user);
        checkoutPage.sectionStreetAddress(user);
        assertThat(checkoutPage.validateResult()).isEqualTo("State / Province is required");
    }

    @Category(ValidatePostalCodeIsRequired.class)

    @Test
    public void validatePostalCodeIsEmpty() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionName(user);
        checkoutPage.sectionLastName(user);
        checkoutPage.sectionStreetAddress(user);
        checkoutPage.sectionState(user);

        assertThat(checkoutPage.validateResult()).isEqualTo("Postal code is required");
    }

    @Category(ValidateEmailAddressIsRequired.class)
    @Test
    public void validateEmailAddressIsEmpty() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionName(user);
        checkoutPage.sectionLastName(user);
        checkoutPage.sectionStreetAddress(user);
        checkoutPage.sectionState(user);
        checkoutPage.sectionPostalCode(user);

        assertThat(checkoutPage.validateResult()).isEqualTo("Email address is required");
    }

    @Category(ValidatePhoneNumberIsRequired.class)
    @Test
    public void validatePhoneNumberIsEmpty() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.sectionName(user);
        checkoutPage.sectionLastName(user);
        checkoutPage.sectionStreetAddress(user);
        checkoutPage.sectionState(user);
        checkoutPage.sectionPostalCode(user);
        checkoutPage.sectionEmail(user);
        assertThat(checkoutPage.validateResult()).isEqualTo("Phone number is required");
    }
}
