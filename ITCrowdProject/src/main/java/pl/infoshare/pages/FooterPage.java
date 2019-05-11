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


    public FooterPage(WebDriver driver) {
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/";
        this.driver.get(this.url);
        this.signInButton=new Button(this.driver, this.signInLink);
        this.handbagsButton=new Button(this.driver, this.handbagsLink);
        this.homeButton = new Button(this.driver, this.homeLink);
        this.laptopBagsButton = new Button(this.driver, this.laptopBagsLink);
    }

    public void clickSignIn() {
        this.signInButton.click();
    }

    public void clickHandbagsButtonOnFooter() {
        this.handbagsButton.click();
    }

    public void clickHomeButtonOnFooter() {
        this.homeButton.safeClick();
    }

        public void clickLaptopBagsButtonOnFooter() {
            this.laptopBagsButton.();
        }
    }



