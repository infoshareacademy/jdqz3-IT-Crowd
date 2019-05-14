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
import pl.infoshare.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;


public class FooterTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;
    private Bag randomBag;
    private Bag randomBagNext;
    private Bag randomLaptopBag;

    @Before
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.basePage = new BasePage(driver);
        this.user = new RegisteredUser(true);
    }

    @After
    public void closeBrowser() {
        basePage.close();
    }



    @Category(HandbagsOnFooter.class)
    @Test
    public void handbagsOnFooter() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickHandbagsButtonOnFooter();

        HandbagCataloguePage handbagText = new HandbagCataloguePage(driver);
        assertThat(handbagText.handbagText()).isEqualTo("Handbags");

    }
    @Category(HomeOnFooter.class)
    @Test
    public void homeFooter(){
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickHomeButtonOnFooter();

        MainPage mainPage = new MainPage(driver);
        assertThat(mainPage.featuredItemsText()).isEqualTo("Featured items");

    }

    @Category(LaptopBagsOnFooter.class)
    @Test
    public void laptopBagsOnFooter() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickLaptopBagsButtonOnFooter();

        LaptopBagsCataloguePage laptopBagsCataloguePage = new LaptopBagsCataloguePage(driver);
        assertThat(laptopBagsCataloguePage.laptopBagText()).isEqualTo("Laptop bags");

    }

    @Category(ContactUsOnFooter.class)
    @Test
    public void ContactUsOnFooter(){
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickContactUsButtonOnFooter();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        assertThat(contactUsPage.contactUsText()).isEqualTo("Contact us");
    }

    @Category(RegisterOnFooter.class)
    @Test
    public void RegisterOnFooter(){
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickRegisterButtonOnFooter();

        RegisterPage registerPage = new RegisterPage(driver);
        assertThat(registerPage.registerText()).isEqualTo("Personal information");
    }


}