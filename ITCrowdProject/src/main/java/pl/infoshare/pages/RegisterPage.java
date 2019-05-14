package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Label;

public class RegisterPage extends BasePage {
    private By registerText = By.xpath("//*[@id=\"main-content\"]/h1");
    private Label register;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String registerText() {
        this.registerText = By.xpath("/html/body/div[4]/div/div/div[1]/div[1]/h3");
        this.register = new Label(this.driver, this.registerText);
        return this.register.getText();
    }
}