package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Label;

public class OrderConfirmationPage extends BasePage {
    private  By orderCompletedText;
    private Label orderCompleted;
    private By orderIdText;
    private Label orderNumber;

    public OrderConfirmationPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/order/confirmation.html";
        this.driver.get(this.url);
    }

    public String readOrderCompleted() {
        this.orderCompletedText=By.cssSelector("#main-content > h1");
        this.orderCompleted = new Label(this.driver, this.orderCompletedText);
        return this.orderCompleted.getText();
    }

    public String readOrderNumber() {
        this.orderIdText=By.cssSelector("#main-content > div > div > p:nth-child(2)");
        this.orderNumber = new Label(this.driver, this.orderIdText);
        return this.orderNumber.getText();
    }
}
