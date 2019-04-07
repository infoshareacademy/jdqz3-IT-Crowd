package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Label;

public class ContactUsPage extends BasePage{

    private By contactUsText = By.cssSelector("#main-content > h1");
    private Label contactUs;

    public ContactUsPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/store/contactus.html";
        this.driver.get(this.url);
    }

    public String verifyContactUsText(){
        this.contactUs = new Label(this.driver, this.contactUsText);
        return this.contactUs.getText();
    }

}

