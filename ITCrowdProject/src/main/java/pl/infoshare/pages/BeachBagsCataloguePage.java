package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;

public class BeachBagsCataloguePage extends BasePage{

    private final By vintageBeachBagLink  = By.cssSelector("#productsContainer [class='col-md-4 col-sm-6 col-xs-12 product']:nth-of-type(1) h3");
    private Button addToCart;
    private By shippingCartLink= By.cssSelector("#miniCartSummary a span");
    private Button shoppingCart;
    private By chackoutLink;
    private Button checkout;
    private By randomBag;
    private By beachBagsText = By.xpath("//*[@id=\"mainContent\"]/header/div[1]/div/h2");
    private Label beachBags;


    public BeachBagsCataloguePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        this.addToCart.doubleClick();
    }

    public void checkout(){
        this.shoppingCart = new Button(this.driver, this.shippingCartLink);
        this.shoppingCart.safeClick();
        this.chackoutLink= By.cssSelector("li.checkout-bg a");
        this.checkout= new Button(this.driver, this.chackoutLink);
        checkout.clickWithJs();
    }

    public void getRandomBag(String name){
        randomBag = By.cssSelector("#productsContainer [item-name='"+name+"'] div.store-btn-addtocart");
        this.addToCart = new Button(this.driver, this.randomBag);
    }

    public String beachBagsText() {
        this.beachBagsText = By.xpath("//*[@id=\"mainContent\"]/header/div[1]/div/h2");
        this.beachBags = new Label(this.driver, this.beachBagsText);
        return this.beachBags.getText();
    }
}
