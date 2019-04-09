package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.pages.sections.ShippingCart;
import pl.infoshare.elements.Label;


public class HandbagCataloguePage extends BasePage {

    private final By chickVintageDeVilleLink = By.cssSelector("#productsContainer [item-name='Chic vintage DeVille'] div.store-btn-addtocart");
    private Button addToCart;
    private By chackoutLink;
    private Button checkout;
    private By randomBag;
    private By handbagsText;
    private Label handbags;


    private ShippingCart shippingCart;

    public HandbagCataloguePage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/category/handbags.html/ref=c:1";
        this.driver.get(this.url);
        this.addToCart = new Button(this.driver, this.chickVintageDeVilleLink);
    }

    public void addToCart(){
        this.addToCart.click();
    }

    public void clickOnShipping() {
        shippingCart = new ShippingCart(this.driver);
        this.shippingCart.getShippingCart();
    }

    public void checkout(){
        this.chackoutLink= By.cssSelector("li.checkout-bg a");
        this.checkout= new Button(this.driver, this.chackoutLink);
        checkout.clickWithJs();
    }

    public void getRandomBag(String name){
        randomBag = By.cssSelector("#productsContainer [item-name='"+name+"'] div.store-btn-addtocart");
        this.addToCart = new Button(this.driver, this.randomBag);
    }


    public String handbagText() {
        this.handbagsText=By.xpath("//h2[@class='shop-banner-title lead']");
        this.handbags = new Label(this.driver, this.handbagsText);
        return this.handbags.getText();
    }
}
