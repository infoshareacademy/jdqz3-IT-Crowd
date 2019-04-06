package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.TextInput;

public class ReviewYourOrderPage extends BasePage {

    private By proceedToCheckoutLink = By.cssSelector(".wc-proceed-to-checkout  a");
    private Button proceedToCheckout;
    private By cartItem = By.cssSelector("#mainCartTable tbody tr td:nth-child(1) div div.col-sm-8 span strong");
    private Label item;
    private By cartQuantity  = By.cssSelector(".input-small[name='quantity']");
    private Label quantity;
    private By cartPrice = By.cssSelector("#mainCartTable  tbody  tr td:nth-child(3) strong");
    private Label price;
    private By cartTotal = By.cssSelector("#mainCartTable tbody tr td:nth-child(4) strong");
    private Label total;
    private By cartTotalsSubtotal = By.cssSelector("div.cart_totals div table tbody tr:nth-child(1) td span");
    private Label totalsSubtotal;
    private By cartTotalsTotal = By.cssSelector("div.cart_totals div table tbody tr:nth-child(2) td span");
    private Label totalsTotal;

    private By quantityText = By.cssSelector(".input-small[name='quantity']");
    private TextInput quantityInput;

    private By recalculateLink = By.xpath("//a[contains(text(),'Recalculate')]");
    private Button recalculate;


    public ReviewYourOrderPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html";
        this.driver.get(this.url);
        this.proceedToCheckout = new Button(this.driver, this.proceedToCheckoutLink);
    }

    public void proceedToCheckout(){
        this.proceedToCheckout.clickWithJs();
    }

    public Label getItem() {
        this.item = new Label(this.driver, this.cartItem);
        return item;
    }

    public Label getQuantity() {
        this.quantity = new Label(this.driver, this.cartQuantity);
        return quantity;
    }

    public Label getPrice() {
        this.price = new Label(this.driver, this.cartPrice);
        return price;
    }

    public Label getTotal() {
        this.total = new Label(this.driver, this.cartTotal);
        return total;
    }

    public Label getTotalsSubtotal() {
        this.totalsSubtotal = new Label(this.driver, this.cartTotalsSubtotal);
        return totalsSubtotal;
    }

    public Label getTotalsTotal() {
        this.totalsTotal = new Label(this.driver, this.cartTotalsTotal);
        return totalsTotal;
    }

    public TextInput inputQuantity(){
        this.quantityInput = new TextInput(this.driver, this.quantityText);
        this.quantityInput.sendKeys("3");
        return quantityInput;
    }

    public Button recalculateButtonClick(){
        this.recalculate = new Button(this.driver, this.recalculateLink);
        this.recalculate.safeClick();
        return recalculate;
    }

}

