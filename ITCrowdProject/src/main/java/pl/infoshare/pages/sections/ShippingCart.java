package pl.infoshare.pages.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;

public class ShippingCart {
    public By shippingCartLink= By.cssSelector("#miniCartSummary a span");
    public Button shippingCart;

    public ShippingCart(WebDriver driver){
        this.shippingCart = new Button(driver, this.shippingCartLink);
    }

    public void getShippingCart(){
        this.shippingCart.safeClick();
    }
}
