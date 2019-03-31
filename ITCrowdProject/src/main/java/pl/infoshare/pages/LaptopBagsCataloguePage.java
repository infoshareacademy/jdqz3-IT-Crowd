package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.pages.Sections.ShippingCart;


public class LaptopBagsCataloguePage extends BasePage {

    private Button addToCart;
    private By chackoutLink;
    private Button checkout;
    private By bag;
    private ShippingCart shippingCart;

    public LaptopBagsCataloguePage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/category/laptop-bags.html/ref=c:50,51";
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
        this.chackoutLink= By.cssSelector("li.checkout-bg a");
        this.checkout= new Button(this.driver, this.chackoutLink);
        checkout.clickWithJs();
    }

    public void getRandomBag(String name){
        bag = By.cssSelector("#productsContainer [item-name='"+name+"'] div.store-btn-addtocart");
        this.addToCart = new Button(this.driver, this.bag);
    }
}
