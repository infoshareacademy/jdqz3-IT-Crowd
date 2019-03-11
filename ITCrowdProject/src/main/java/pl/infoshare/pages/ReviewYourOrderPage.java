package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;

public class ReviewYourOrderPage extends BasePage {

    private By proceedToCheckoutLink = By.cssSelector(".wc-proceed-to-checkout > a");
    private Button proceedToCheckout;
    private By cartItem = By.cssSelector("#mainCartTable > tbody > tr > td:nth-child(1) > div > div.col-sm-8 > span > strong");
    private Label item;
    private By cartQuantity  = By.xpath("//*[@id='14102']");
    private Label quantity;
    private By cartPrize = By.cssSelector("#mainCartTable > tbody > tr > td:nth-child(3) > strong");
    private Label prize;
    private By cartTotal = By.cssSelector("#mainCartTable > tbody > tr > td:nth-child(4) > strong");
    private Label total;

    public ReviewYourOrderPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html";
        this.driver.get(this.url);
        this.proceedToCheckout = new Button(this.driver, this.proceedToCheckoutLink);
    }

    public void proceedToCheckout(){
        this.proceedToCheckout.clickWithJs();
    }

    public boolean isCartContentCorrect(){
        if(this.cartItem != null && this.quantity != null && this.prize != null && this.total != null){
            return  true;
        } else {
            return false;
        }
    }
//
//    public boolean isCartContentCorrect(){
//        String actualName = new Label(this.driver, addedItemNameSelector).read();
//        int actualQuantity = Integer.parseInt(new Label(this.driver, addedItemQuantitySelector).getValue());
//        double actualPrice = Double.parseDouble(new Label(this.driver, addedItemPriceSelector).read().substring(1));
//        double actualTotal = Double.parseDouble(new Label(this.driver, addedItemTotalSelector).read().substring(1));
//
//        String expectedName = "Chic vintage DeVille";
//        int expectedQuantity = 1;
//        double expectedPrice = 78.00;
//        double expectedTotal = expectedPrice * expectedQuantity;
//
//        return actualName.equals(expectedName) && actualQuantity == expectedQuantity && actualPrice == expectedPrice && actualTotal == expectedTotal;
//    }
}

