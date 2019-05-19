package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;

import javax.swing.plaf.PanelUI;

public class MainPage extends BasePage {
    private By handbagsLink;
    private Button handbagsButton;
    private By categoryLink;
    private Button categoryButton;
    private By featuredItemsText;
    private Label featuredItems;
    private By myAccountLink;
    private Button myAccountButton;
    private By myAccountRegisterLink;
    private Button myAccountRegisterButton;


    public MainPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
    }

    public void chooseHandbagsCategory(){
        this.handbagsLink=By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='Handbags']");
        this.handbagsButton = new Button(this.driver, this.handbagsLink);
        this.handbagsButton.click();
    }

    public void chooseCategory(String category){
        this.categoryLink=By.xpath("//div[contains(@class, 'mainmenu')]//a[text()='"+category+"']");
        this.categoryButton = new Button(this.driver, this.categoryLink);
        this.categoryButton.click();
    }

    public String featuredItemsText(){
        this.featuredItemsText = By.cssSelector("body > div.slider-area > div.container > h2");
        this.featuredItems = new Label (this.driver, this.featuredItemsText);
        return this.featuredItems.getText();
    }

    public void clickOnMyAccountButton(){
        this.myAccountLink = By.cssSelector("#customerAccount > ul > li > a");
        this.myAccountButton = new Button(this.driver,this.myAccountLink);
        this.myAccountButton.doubleClick();
    }

    public void clickOnMyAccountRegisterButton(){
        this.myAccountRegisterLink = By.cssSelector("#registerLink");
        this.myAccountRegisterButton = new Button(this.driver, this.myAccountRegisterLink);
        this.myAccountRegisterButton.doubleClick();
    }



}
