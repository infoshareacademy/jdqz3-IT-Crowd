package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;

public class FooterPage extends BasePage {
    private By signInLink = By.cssSelector("div.footer-area.ptb-80 a[href='/shop/customer/customLogon.html']");
    private Button signInButton;
    private By handbagsLink = By.xpath("//span[contains(text(),'Handbags')]");
    private Button handbagsButton;
    private By laptopBagsLink = By.cssSelector(".usefull-link li:nth-of-type(4) .name");
    private Button laptopBagsButton;

    private By homeLink = By.xpath("//a[contains(text(),'Home')]");
    private Button homeButton;
    private By contactUsLink = By.cssSelector("body > div.footer-area.ptb-80 > div > div > div:nth-child(2) > div > div > ul > li:nth-child(6) > a");
    private Button contactUsButton;
    private By registerLink = By.cssSelector("body > div.footer-area.ptb-80 > div > div > div:nth-child(2) > div > div > ul > li:nth-child(7) > a");
    private Button registerButton;
    private By beachBagsLink = By.cssSelector("body > div.footer-area.ptb-80 > div > div > div:nth-child(2) > div > div > ul > li:nth-child(3) > a > span");
    private Button beachButton;




    public FooterPage(WebDriver driver) {
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
        this.signInButton=new Button(this.driver, this.signInLink);
        this.handbagsButton=new Button(this.driver, this.handbagsLink);
        this.homeButton = new Button(this.driver, this.homeLink);
        this.laptopBagsButton = new Button(this.driver, this.laptopBagsLink);
        this.contactUsButton = new Button(this.driver,this.contactUsLink);
        this.registerButton = new Button(this.driver, this.registerLink);
        this.beachButton = new Button(this.driver, this.beachBagsLink);
    }

    public void clickSignIn(){
        this.signInButton.doubleClick();
    }

    public void clickHandbagsButtonOnFooter(){
        this.handbagsButton.doubleClick();
    }

    public void clickHomeButtonOnFooter() {
        this.contactUsButton.safeClick();
    }

    public void clickLaptopBagsButtonOnFooter(){
        this.laptopBagsButton.doubleClick();
    }

    public void clickRegisterButtonOnFooter(){
        this.registerButton.doubleClick();
    }

    public void clickContactUsButtonOnFooter(){
        this.contactUsButton.doubleClick();
    }

    public void clickBeachBagsOnFooter(){this.beachButton.doubleClick();}
}