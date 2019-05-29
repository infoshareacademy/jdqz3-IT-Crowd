package pl.infoshare.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.categories.RegisterUnderMyAccount;
import pl.infoshare.categories.SignInUnderMyAccount;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.BasePage;
import pl.infoshare.pages.CustomLogonPage;
import pl.infoshare.pages.MainPage;
import pl.infoshare.pages.RegisterPage;

import static org.assertj.core.api.Assertions.assertThat;


public class MyAccountTests {

    private WebDriver driver;
    private BasePage basePage;
    private RegisteredUser user;



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

    @Category(RegisterUnderMyAccount.class)
    @Test
    public void registerUnderMyAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnMyAccountButton();
        mainPage.clickOnMyAccountRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        assertThat(registerPage.registerText()).isEqualTo("Personal information");
    }

    @Category(SignInUnderMyAccount.class)
    @Test
    public void signInUnderMyAccount(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnMyAccountButton();
        mainPage.clickOnMyAccountSignInButton();

        CustomLogonPage customLogonPage = new CustomLogonPage(driver,true);
        assertThat(customLogonPage.isRegisteredCustomerSection()).isEqualTo("Registered customer");

    }
}
