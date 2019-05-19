package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.TextInput;


public class CustomLogonPage extends BasePage {

    private By customerEmailAddressElement = By.id("#signin_userName");
    private TextInput customerEmailAddress;
    private By passwordElement = By.id("#signin_password");
    private TextInput password;
    private By signInElement = By.id("#genericLogin-button");
    private Button signIn;
    private By registerElement = By.cssSelector(".login-btn[href='/shop/customer/registration.html']");
    private Button register;

    private By registeredCustomerElement = By.cssSelector("body > div.login-area.ptb-80 > div > div > div:nth-child(1) > div.login-title > h3");
    private Label registeredCustomer;
    private By newCustomerElement = By.xpath("//div[2]/div/h3");
    private Label newCustomer;
    private By loginErrorText = By.cssSelector("#loginError");
    private Label loginErrorValidation;


    public CustomLogonPage(WebDriver driver){
        super(driver);

        this.url = "http://demo.shopizer.com:8080/shop/customer/customLogon.html";
        this.driver.get(this.url);
        this.customerEmailAddress = new TextInput(this.driver, this.customerEmailAddressElement);
        this.password = new TextInput(this.driver, this.passwordElement);
        this.signIn = new Button(this.driver, this.signInElement);
        this.register = new Button(this.driver, this.registerElement);
        this.registeredCustomer = new Label(this.driver, this.registeredCustomerElement);
        this.newCustomer = new Label(this.driver, this.newCustomerElement);
    }

    public CustomLogonPage(WebDriver driver,boolean missStepsInsideConstructor){
        super(driver);
    }

    public String isRegisteredCustomerSection() {
        this.registeredCustomerElement = By.cssSelector("body > div.login-area.ptb-80 > div > div > div:nth-child(1) > div.login-title > h3");
        this.registeredCustomer = new Label(this.driver);
        return this.registeredCustomer.getText(this.registeredCustomerElement);
    }

    public String isNewCustomerSection() {
        return this.newCustomer.getText();
    }

    public void clickSignInButtonOnCustomLogonPage() {
        this.signIn = new Button(this.driver, this.signInElement);
        this.signIn.click();
    }
    public String LoginErrorValidationOnCustomLogonPage(){
        this.loginErrorValidation = new Label(this.driver, this.loginErrorText);
        this.loginErrorValidation.getText();
        return this.loginErrorValidation.getText();
    }
    public void EmptyPasswordValidationOnCustomLogonPage(){
        this.customerEmailAddress = new TextInput(this.driver, this.customerEmailAddressElement);
        this.customerEmailAddress.sendKeys("test") ;


    }


}
