package pl.infoshare.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Label {
    private  int timeout =10;
    private WebElement element;
    private WebDriver driver;


    public Label(WebDriver driver, By by){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable((by)));
    }
    public Label(WebDriver driver){
        this.driver = driver;
    }
    public String getText(){
        return this.element.getText();
    }
    public String getText(By by){
        WebDriverWait wait  = new WebDriverWait(this.driver,timeout);

        return driver.findElement(by).getText();
    }

    public String getValue(){
        return this.element.getAttribute("value");
    }

}
