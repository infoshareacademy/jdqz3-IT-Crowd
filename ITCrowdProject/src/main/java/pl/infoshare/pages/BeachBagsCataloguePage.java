package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;


public class BeachBagsCataloguePage extends BasePage {

    private Button addToCart;
    private By shippingCartLink= By.cssSelector("#miniCartSummary a span");
    private Button shoppingCart;
    private By chackoutLink;
    private Button checkout;
    private By bag;
    private By titleElement=By.cssSelector("h2.shop-banner-title");
    private Label title;

    public BeachBagsCataloguePage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/category/beachbags.html/ref=c:*";
        this.driver.get(this.url);
        this.title= new Label(this.driver, this.titleElement);
    }

    public void addToCart(){
        this.addToCart.click();
    }

    public void checkout(){
        this.shoppingCart = new Button(this.driver, this.shippingCartLink);
        this.shoppingCart.scrollWithJs();
        this.shoppingCart.safeClick();
        this.chackoutLink= By.cssSelector("li.checkout-bg a");
        this.checkout= new Button(this.driver, this.chackoutLink);
        checkout.clickWithJs();
    }

    public void getRandomBag(String name){
        bag = By.cssSelector("#productsContainer [item-name='"+name+"'] div.store-btn-addtocart");
        this.addToCart = new Button(this.driver, this.bag);
    }

    public String getTitlePage(){
        return this.title.getText();
    }

}
