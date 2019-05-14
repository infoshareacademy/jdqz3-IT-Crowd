package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Label;

public class ContactUsPage extends BasePage {
    private By contactUsText = By.xpath("//*[@id=\"main-content\"]/h1");
    private Label contactUs;


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public String contactUsText() {
        this.contactUsText = By.xpath("//*[@id=\"main-content\"]/h1");
        this.contactUs = new Label(this.driver, this.contactUsText);
        return this.contactUs.getText();
    }
}