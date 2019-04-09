package pl.infoshare.pages.waitForPage;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.infoshare.pages.BasePage;

public class WaitForLoginPage extends BasePage {

    public WaitForLoginPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/customer/customLogon.html";
        this.driver.get(this.url);
    }

    public void waitForLoginPage() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
