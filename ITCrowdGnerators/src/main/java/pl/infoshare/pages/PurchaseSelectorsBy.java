package pl.infoshare.pages;

import org.openqa.selenium.By;

public class PurchaseSelectorsBy {
    private By HandbagsLink=By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
    private By ChickVintageDeVilleLink=By.cssSelector("#productsContainer > .col-md-4:nth-child(2) .addToCart");
    private By ShippingCartLink=By.xpath("//*[@id='miniCartSummary']/a[text()='Shopping cart ']");
    private By ChackoutLink=By.cssSelector(".checkout-bg > a");
    private By ProceedTpCheckoutLink=By.cssSelector(".wc-proceed-to-checkout > a");
    private By FirstNameInput=By.cssSelector("input[name='customer.billing.firstName']");
    private By LastNameInput=By.cssSelector("input[name='customer.billing.lastName']");
    private By StreetInput=By.cssSelector("input[name='customer.billing.address']");
    private By CityInput=By.cssSelector("input[name='customer.billing.city']");
    private By CountrySelect=By.cssSelector("select[name='customer.billing.country']");
    private By StateInput=By.cssSelector("input[name='customer.billing.stateProvince']");
    private By PostalCodeInput=By.cssSelector("input[name='customer.billing.postalCode']");
    private By EmailInput=By.cssSelector("input[name='customer.emailAddress']");
    private By PhoneNumberInput=By.cssSelector("input[name='customer.billing.phone']");
    private By SubmitOrderBy=By.id("submitOrder");
    private By OrderIdText=By.cssSelector("#main-content > div > div > p:nth-child(2)");

    public By getHandbagsLink() {
        return HandbagsLink;
    }

    public By getChickVintageDeVilleLink() {
        return ChickVintageDeVilleLink;
    }

    public By getShippingCartLink() {
        return ShippingCartLink;
    }

    public By getChackoutLink() {
        return ChackoutLink;
    }

    public By getProceedToCheckoutLink() {
        return ProceedTpCheckoutLink;
    }

    public By getFirstNameInput() {
        return FirstNameInput;
    }

    public By getLastNameInput() {
        return LastNameInput;
    }

    public By getStreetInput() {
        return StreetInput;
    }

    public By getCityInput() {
        return CityInput;
    }

    public By getCountrySelect() {
        return CountrySelect;
    }

    public By getStateInput() {
        return StateInput;
    }

    public By getPostalCodeInput() {
        return PostalCodeInput;
    }

    public By getEmailInput() {
        return EmailInput;
    }

    public By getPhoneNumberInput() {
        return PhoneNumberInput;
    }

    public By getSubmitOrderBy() {
        return SubmitOrderBy;
    }

    public By getOrderIdText() {
        return OrderIdText;
    }
}
