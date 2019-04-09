package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.pages.sections.ShippingCart;


public class CatalouqePage extends BasePage {

    private Button addToCart;
    private By chackoutLink;
    private Button checkout;
    private By bag;
    private ShippingCart shippingCart;

    public CatalouqePage(WebDriver driver, String url){
        super(driver);
        this.url = url;
        this.driver.get(this.url);
    }

    public void addToCart(){
        this.addToCart.click();
    }

    public void clickOnShipping() {
        shippingCart = new ShippingCart(this.driver);
        this.shippingCart.getShippingCart();
    }

    public void checkout(){
         this.chackoutLink= By.cssSelector("li.checkout-bg  a");
        this.checkout= new Button(this.driver, this.chackoutLink);
        checkout.clickWithJs();
    }

    public void getRandomBag(String name){
        bag = By.cssSelector("#productsContainer [item-name='"+name+"'] div.store-btn-addtocart");
        this.addToCart = new Button(this.driver, this.bag);
    }
}
