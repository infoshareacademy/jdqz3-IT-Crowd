package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Label;

public class BeachBagsCataloguePage extends BasePage{
        private By beachBagsText = By.xpath("//*[@id=\"mainContent\"]/header/div[1]/div/h2");
        private Label beachBags;


    public BeachBagsCataloguePage(WebDriver driver) {
        super(driver);
    }

        public String beachBagsText() {
        this.beachBagsText = By.xpath("//*[@id=\"mainContent\"]/header/div[1]/div/h2");
        this.beachBags = new Label(this.driver, this.beachBagsText);
        return this.beachBags.getText();
    }

}
