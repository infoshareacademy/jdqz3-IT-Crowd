package pl.infoshare.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.infoshare.dataModels.Address;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.pages.PurchaseSelectorsDirect;
import pl.infoshare.utils.FindByElement;
import pl.infoshare.utils.SetBrowser;

public class PurchaseTest {

    private PurchaseSelectorsDirect element;
    private FindByElement methoda;
    private WebDriver driver;
    private SetBrowser browser;
    private Address address;
    private RegisteredUser user;


    @Before
     public void startBrowser() {
     //   System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        element = new PurchaseSelectorsDirect(driver);
        browser = new SetBrowser("http://demo.shopizer.com:8080/shop/", driver  );
        user = new RegisteredUser(false);
        address = new Address(true);

    }

    @After
    public void close() {
        browser.closeDriver();
    }

    @Test
    public void purchase() {
        element.getHandbagsButton().click();
        element.getChickVintageDeVilleButton().click();
        element.getShippingCartButton().click();
        element.getShippingCartButton().safeClick();
        element.getChackouButton().click();
        element.getProceedToCheckoutButton().clickWithJs();
        element.getFirstNameTextInput().sendKeys(user.getFirstname());
        element.getLastNameTextInput().sendKeys(user.getLastname());
        element.getStreetTextInput().sendKeys(address.getStreetAddress());
        element.getCityTextInput().sendKeys(address.getCity());
        element.getCountryTextSelect().selectText(address.getCountry());
        element.getStateTextInput().sendKeys(address.getCity());
        element.getPostalCodeTextInput().sendKeys(address.getPostalCode());
        element.getEmailTextInput().sendKeys(user.getEmail());
        element.getPhoneNumberTextInput().sendKeys(user.getPhoneNumber());
        element.getSubmitOrderButton().safeClick();

        try {
            element.getOrderIdLabelText().getInput();
        }
        catch(RuntimeException e) {
            System.out.println(e);
        }
        System.out.println(element.getOrderIdLabelText().getInput());
    }
}
