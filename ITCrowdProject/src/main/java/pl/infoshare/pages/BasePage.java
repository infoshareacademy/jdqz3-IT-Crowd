package pl.infoshare.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected String url;
    protected String window;

    public BasePage(WebDriver driver){
        this.driver = driver;
        if (this.window == null){
            window = this.driver.getWindowHandle();
        }
        this.driver.manage().window().maximize();
        waitForPage();
    }

    private void waitForPage(){
        WebDriverWait wait = new WebDriverWait(driver, 40);
        JavascriptExecutor runner = (JavascriptExecutor) driver;
        wait.until((ExpectedCondition<Boolean>) driver
                -> (runner.executeScript("return document.readyState").equals("complete")));
    }

    public void close(){
        this.driver.quit();
    }
}
