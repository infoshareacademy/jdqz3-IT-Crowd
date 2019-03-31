package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;

public class FooterPage extends BasePage {
    private By signInLink=By.cssSelector("div.footer-area.ptb-80 a[href='/shop/customer/customLogon.html']");
    private Button signInButton;
    private By handbagsLink=By.xpath("//span[contains(text(),'Handbags')]");
    private Button handbagsButton;

    public FooterPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
        this.signInButton=new Button(this.driver, this.signInLink);
        this.handbagsButton=new Button(this.driver, this.handbagsLink);
    }

    public void clickSignIn(){
        this.signInButton.click();
    }

    public void clickHandbagsButtonOnFooter(){
        this.handbagsButton.click();
    }


}