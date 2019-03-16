package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;

public class MainPage extends BasePage {
    private By handbagsLink;
    private Button handbagsButton;
    private By categoryLink;
    private Button categoryButton;

    public MainPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
       // this.handbagsButton = new Button(this.driver, this.handbagsLink);
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
}
