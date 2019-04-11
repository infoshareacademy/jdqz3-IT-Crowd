package pl.infoshare.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.categories.*;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Bag;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.*;

import static org.assertj.core.api.Assertions.assertThat;


public class FooterTest {

    private WebDriver driver;
    private BasePage basePage;
    private Address address;
    private RegisteredUser user;
    private Bag randomBag;
    private Bag randomBagNext;
    private Bag randomLaptopBag;

    @BeforeClass
    public static void beforeAll(){
        WebDriverManager.chromedriver().setup();
    }

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

    @Category(HandbagsOnFooter.class)
    @Test
    public void handbagsOnFooter() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickHandbagsButtonOnFooter();

        HandbagCataloguePage handbagText = new HandbagCataloguePage(driver);
        assertThat(handbagText.handbagText()).isEqualTo("Handbags");
    }

    @Category(SignInOnFooter.class)
    @Test
    public void signInOnFooter() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickSignIn();
            CustomLogonPage customLogonPage = new CustomLogonPage(driver);
            assertThat(customLogonPage.isRegisteredCustomerSection()).isEqualTo("Registered customer");
            assertThat(customLogonPage.isNewCustomerSection()).isEqualTo("New customer");
    }

    @Category(BeachBagsOnFooter.class)
    @Test
    public void beachBagsOnFooter() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickBeachBags();

        BeachBagsCataloguePage beachBagsCataloguePage = new BeachBagsCataloguePage(driver);
        assertThat(beachBagsCataloguePage.getTitlePage()).isEqualTo("Beach bags");
    }

}


