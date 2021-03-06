package pl.infoshare.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.categories.QuantityIncreaseTest;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Bag;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.*;
import pl.infoshare.pages.waitForPage.WaitForPage;

import static org.assertj.core.api.Assertions.assertThat;

public class QuantityTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;
    private Bag randomBag;
    private Bag randomBagNext;
    private Bag randomLaptopBag;
    private Object browser;
    private WebElement __document;

    @Rule
    public TestName testName = new TestName();
    @Before
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
        this.user = new RegisteredUser(true);

    }

    @After
    public void closeBrowser() {
        basePage.screenShoot(testName.getMethodName());
        basePage.close();
    }

    @Category(QuantityIncreaseTest.class)
    @Test
    public void quantityIncrease() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.inputIncreaseQuantity();
        reviewYourOrderPage.recalculateButtonClick();

        WaitForPage waitForPage = new WaitForPage(driver);
        waitForPage.waitForPage();


        assertThat(reviewYourOrderPage.getTotal().getText()).isEqualTo("$234.00");
    }

    @Category(QuantityIncreaseTest.class)
    @Test
    public void quantityDecrease() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseHandbagsCategory();

        HandbagCataloguePage handbagCataloguePage = new HandbagCataloguePage(driver);
        handbagCataloguePage.addToCart();
        handbagCataloguePage.clickOnShipping();
        handbagCataloguePage.checkout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(driver);
        reviewYourOrderPage.inputIncreaseQuantity();
        reviewYourOrderPage.recalculateButtonClick();

        WaitForPage waitForPage = new WaitForPage(driver);
        waitForPage.waitForPage();

        reviewYourOrderPage.inputDecreaseQuantity();
        reviewYourOrderPage.recalculateButtonClick();

        waitForPage.waitForPage();


        assertThat(reviewYourOrderPage.getTotal().getText()).isEqualTo("$156.00");
    }
}
