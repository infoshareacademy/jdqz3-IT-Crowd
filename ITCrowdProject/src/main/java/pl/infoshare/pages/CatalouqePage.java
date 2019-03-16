package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;


public class CatalouqePage extends BasePage {

    private Button addToCart;
    private By shippingCartLink= By.xpath("//*[@id='miniCartSummary']/a[text()='Shopping cart ']");
    private Button shoppingCart;
    private By chackoutLink;
    private Button checkout;
    private By bag;

    public CatalouqePage(WebDriver driver, String url){
        super(driver);
        this.url = url;
        this.driver.get(this.url);
    }

    public void addToCart(){
        this.addToCart.click();
    }

    public void checkout(){
        this.shoppingCart = new Button(this.driver, this.shippingCartLink);
        this.shoppingCart.click();
        this.shoppingCart.safeClick();
        this.chackoutLink= By.cssSelector(".checkout-bg > a");
        //this.chackoutLink= By.cssSelector("#miniCartDetails > li.checkout-bg > a");
        this.checkout= new Button(this.driver, this.chackoutLink);
        checkout.clickWithJs();
        //checkout.click();
    }

    public void getRandomBag(String name){
        bag = By.cssSelector("#productsContainer [item-name='"+name+"'] .addToCart");
        this.addToCart = new Button(this.driver, this.bag);
    }
}
