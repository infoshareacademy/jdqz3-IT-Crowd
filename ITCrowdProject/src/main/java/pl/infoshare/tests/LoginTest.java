package pl.infoshare.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.categories.ValidateLoginFieldRequired;
import pl.infoshare.categories.ValidateLoginPasswordFieldRequired;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.Bag;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.BasePage;
import pl.infoshare.pages.CustomLogonPage;
import pl.infoshare.pages.FooterPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
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
    }

    @After
    public void closeBrowser() {
        basePage.close();
    }


    @Category(ValidateLoginFieldRequired.class)
    @Test
    public void LoginEmptyFieldsValidation() {
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickSignIn();


        CustomLogonPage customLogonPage = new CustomLogonPage(driver);
        customLogonPage.clickSignInButtonOnCustomLogonPage();


        assertThat(customLogonPage.LoginErrorValidationOnCustomLogonPage()).isEqualTo("Login Failed. Username or Password is incorrect.");

    }

    @Category(ValidateLoginPasswordFieldRequired.class)
    @Test
    public void LoginEmptyPasswordFieldValidation(){
        FooterPage footerPage = new FooterPage(driver);
        footerPage.clickSignIn();

        CustomLogonPage customLogonPage = new CustomLogonPage(driver);
        customLogonPage.EmptyPasswordValidationOnCustomLogonPage();

        customLogonPage.clickSignInButtonOnCustomLogonPage();
        assertThat(customLogonPage.LoginErrorValidationOnCustomLogonPage()).isEqualTo("Login Failed. Username or Password is incorrect.");

    }
}
