package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.TextInput;


public class CustomLogonPage extends BasePage {

    private By customerEmailAddressElement=By.cssSelector("#signin_userName");
    private TextInput customerEmailAddress;
    private By passwordElement=By.cssSelector("#signin_password");
    private TextInput password;
    private By signInElement=By.cssSelector("#genericLogin-button");
    private Button signIn;
    private By registerElement=By.cssSelector(".login-btn[href='/shop/customer/registration.html']");
    private Button register;
    private By registeredCustomerElement=By.xpath("//div[1]/div[1]/h3");
    private Label registeredCustomer;
    private By newCustomerElement=By.xpath("//div[2]/div/h3");
    private Label newCustomer;

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

    public String isRegisteredCustomerSection() {
        return this.registeredCustomer.getText();
    }

    public String isNewCustomerSection() {
        return this.newCustomer.getText();
    }
}