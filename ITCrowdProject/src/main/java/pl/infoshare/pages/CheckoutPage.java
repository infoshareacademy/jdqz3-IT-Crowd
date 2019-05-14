package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.dataModels.RegisteredUser;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.Select;
import pl.infoshare.elements.TextInput;

public class CheckoutPage extends BasePage{

    private By firstNameInput=By.cssSelector("input[name='customer.billing.firstName']");
    private TextInput firstName;
    private By lastNameInput=By.cssSelector("input[name='customer.billing.lastName']");
    private TextInput lastName;
    private By streetInput=By.cssSelector("input[name='customer.billing.address']");
    private TextInput street;
    private By cityInput=By.cssSelector("input[name='customer.billing.city']");
    private TextInput city;
    private By countrySelect;
    private Select country;
    private By stateInput;
    private TextInput state;
    private By postalCodeInput;
    private TextInput postal;
    private By emailInput=By.cssSelector("input[name='customer.emailAddress']");
    private TextInput email;
    private By phoneNumberInput=By.cssSelector("input[name='customer.billing.phone']");
    private TextInput phoneNumber;
    private By submitOrderButton;
    private Button submitOrder;
    private By validateField = By.xpath("//*[@id=\"formErrorMessage\"]/strong/font");
    private Label validate;


    public CheckoutPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/order/checkout.html";
        this.driver.get(this.url);
        this.firstName = new TextInput(this.driver, this.firstNameInput);
        this.lastName = new TextInput(this.driver, this.lastNameInput);
        this.street = new TextInput(this.driver, this.streetInput);
        this.city = new TextInput(this.driver, this.cityInput);
        this.phoneNumber = new TextInput(this.driver, this.phoneNumberInput);
        this.email = new TextInput(this.driver, this.emailInput);
        this.validate = new Label(this.driver,this.validateField);
    }

    public void sectionFullName(RegisteredUser user){
        this.firstName.sendKeys(user.getFirstname());
        this.lastName.sendKeys(user.getLastname());
        this.street.sendKeys(user.getAddress().getStreetAddress());
        this.city.sendKeys(user.getAddress().getCity());
    }

    public void sectionName(RegisteredUser user){
        this.firstName.sendKeys(user.getFirstname());
    }

    public void sectionLastName(RegisteredUser user){
        this.lastName.sendKeys(user.getLastname());
    }

    public void fillInSectionCountryState(RegisteredUser user){
        this.countrySelect=By.cssSelector("select[name='customer.billing.country']");
        this.country = new Select(this.driver, this.countrySelect);
        this.country.selectText(user.getAddress().getCountry());

        this.stateInput=By.cssSelector("input[name='customer.billing.stateProvince']");
        this.state= new TextInput(this.driver, this.stateInput);
        this.state.sendKeys(user.getAddress().getState());

        this.postalCodeInput=By.cssSelector("input[name='customer.billing.postalCode']");
        this.postal = new TextInput(this.driver, this.postalCodeInput);
        this.postal.sendKeys(user.getAddress().getPostalCode());
        this.email.sendKeys(user.getEmail());
        this.phoneNumber.sendKeys(user.getPhoneNumber());
    }

    public void submitOrder() {
        this.submitOrderButton = By.id("submitOrder");
        this.submitOrder = new Button(this.driver, this.submitOrderButton);
        this.submitOrder.safeClick();
    }

    public String validateResult(){
        this.validate = new Label (this.driver, this.validateField);
        return this.validate.getText();
    }


}

