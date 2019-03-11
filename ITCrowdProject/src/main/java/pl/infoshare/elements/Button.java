package pl.infoshare.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button {
    private  int timeout = 20;
    private WebElement element;
    private WebDriver driver;

    public Button(WebDriver driver, By by){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable((by)));
    }

    public Button click(){
       this.element.click();
       return this;
    }

    public Button safeClick(){
        Actions carActionSequence = new Actions(driver);
        carActionSequence.moveToElement(this.element).click().build().perform();
        return this;
    }

    public Button clickWithJs(){
        JavascriptExecutor runner = (JavascriptExecutor) driver;
        String script = "arguments[0].click()";
        runner.executeScript(script, this.element);
        return this;
    }
}
