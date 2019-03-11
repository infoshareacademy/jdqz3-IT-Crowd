package pl.infoshare.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindByElement extends SetBrowser {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebElement findByElement(By byElement) {
        wait.until(ExpectedConditions.elementToBeClickable(((byElement))));
        return driver.findElement(((byElement)));
    }
}
