package pl.infoshare.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetBrowser {

    private WebDriver driver;
    private WebDriverWait wait;

    public SetBrowser() {
    }

    public SetBrowser(String url, WebDriver driver) {
        this.driver = driver;
        startBrowser(url);
    }

    private void startBrowser(String url){
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 40);
        JavascriptExecutor runner = (JavascriptExecutor) driver;
        wait.until((ExpectedCondition<Boolean>) driver ->
                (runner.executeScript("return document.readyState").equals("complete")));
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }
}
