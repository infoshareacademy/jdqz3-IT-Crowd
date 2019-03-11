package pl.infoshare.pages;

import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.Select;
import pl.infoshare.elements.TextInput;

public class PurchaseSelectorsDirect extends PurchaseSelectorsBy{
    private Button HandbagsButton;
    private Button ChickVintageDeVilleButton;
    private Button ShippingCartButton;
    private Button ChackouButton;
    private Button ProceedToCheckoutButton;
    private TextInput FirstNameTextInput;
    private TextInput LastNameTextInput;
    private TextInput StreetTextInput;
    private TextInput CityTextInput;
    private Select CountryTextSelect;
    private TextInput StateTextInput;
    private TextInput PostalCodeTextInput;
    private TextInput EmailTextInput;
    private TextInput PhoneNumberTextInput;
    private Button SubmitOrderButton;
    private Label OrderIdLabelText;
    private WebDriver driver;

    public PurchaseSelectorsDirect(WebDriver driver){
        this.driver=driver;
    }

    public Button getHandbagsButton() {
        Button HandbagsButton = new Button(driver, getHandbagsLink());
        return HandbagsButton;
    }

    public Button getChickVintageDeVilleButton() {
        Button ChickVintageDeVilleButton = new Button(driver, getChickVintageDeVilleLink());
        return ChickVintageDeVilleButton;
    }

    public Button getShippingCartButton() {
        Button ShippingCartButton = new Button(driver, getShippingCartLink());
        return ShippingCartButton;
    }

    public Button getChackouButton() {
        Button ChackouButton = new Button(driver, getChackoutLink());
        return ChackouButton;
    }

    public Button getProceedToCheckoutButton() {
        Button ProceedToCheckoutButton = new Button(driver, getProceedToCheckoutLink());
        return ProceedToCheckoutButton;
    }

    public TextInput getFirstNameTextInput() {
        TextInput FirstNameTextInput = new TextInput(driver, getFirstNameInput());
        return FirstNameTextInput;
    }

    public TextInput getLastNameTextInput() {
        TextInput LastNameTextInput = new TextInput(driver, getLastNameInput());
        return LastNameTextInput;
    }

    public TextInput getStreetTextInput() {
        TextInput StreetTextInput = new TextInput(driver, getStreetInput());
        return StreetTextInput;
    }

    public TextInput getCityTextInput() {
        TextInput CityTextInput = new TextInput(driver, getCityInput());
        return CityTextInput;
    }

    public Select getCountryTextSelect() {
        Select CountryTextSelect = new Select(driver, getCountrySelect());
        return CountryTextSelect;
    }

    public TextInput getStateTextInput() {
        TextInput StateTextInput = new TextInput(driver, getStateInput());
        return StateTextInput;
    }

    public TextInput getPostalCodeTextInput() {
        TextInput PostalCodeTextInput = new TextInput(driver, getPostalCodeInput());
        return PostalCodeTextInput;
    }

    public TextInput getEmailTextInput() {
        TextInput EmailTextInput = new TextInput(driver, getEmailInput());
        return EmailTextInput;
    }

    public TextInput getPhoneNumberTextInput() {
        TextInput PhoneNumberTextInput = new TextInput(driver, getPhoneNumberInput());
        return PhoneNumberTextInput;
    }

    public Button getSubmitOrderButton() {
        Button SubmitOrderButton = new Button(driver, getSubmitOrderBy());
        return SubmitOrderButton;
    }

    public Label getOrderIdLabelText() {
        Label OrderIdLabelText = new Label(driver, getOrderIdText());
        return OrderIdLabelText;
    }
}
