package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.TextInput;


public class CustomLogonPage extends BasePage {

    private By registeredCustomerElement=By.xpath("//div[1]/div[1]/h3");
    private Label registeredCustomer;
    private By newCustomerElement=By.xpath("//div[2]/div/h3");
    private Label newCustomer;

    public CustomLogonPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/customer/customLogon.html";
        this.driver.get(this.url);
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