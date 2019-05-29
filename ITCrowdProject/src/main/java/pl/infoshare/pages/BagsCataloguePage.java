package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.pages.sections.ShippingCart;

public class BagsCataloguePage extends BasePage{



    private Button addToCart;
    private By checkoutLink;
    private Button checkout;
    private By bag;

    private ShippingCart shippingCart;

    public BagsCataloguePage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/category/bags.html/ref=c:52";
        this.driver.get(this.url);
    }

    public void addToCart(){
        this.addToCart.doubleClick();
    }

    public void clickOnShipping() {
        shippingCart = new ShippingCart(this.driver);
        this.shippingCart.getShippingCart();
    }

    public void checkout(){
        this.checkoutLink= By.cssSelector("li.checkout-bg a");
        this.checkout= new Button(this.driver, this.checkoutLink);
        checkout.clickWithJs();
    }

    public void getRandomBag(String name){
        bag = By.cssSelector("#productsContainer [item-name='"+name+"'] div.store-btn-addtocart");
        this.addToCart = new Button(this.driver, this.bag);
    }

}
