package pl.infoshare.pages.thirdParties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.elements.Label;
import pl.infoshare.elements.TextInput;
import pl.infoshare.pages.BasePage;

public class FacebookPage extends BasePage {
    private By facebookTextNewPage = By.xpath("//*[text()='Facebook']");
    private Label facebookTextShopizer;

    public FacebookPage(WebDriver driver) {
        super(driver);

    }

    public String facebookText(){

            this.facebookTextNewPage = By.xpath("//*[text()='Facebook']");
            this. facebookTextShopizer= new Label(this.driver, this.facebookTextNewPage);
            return this.facebookTextShopizer.getText();
        }



}
