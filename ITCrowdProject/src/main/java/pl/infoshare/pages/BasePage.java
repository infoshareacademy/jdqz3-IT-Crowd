package pl.infoshare.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    public void screenShoot(String methodName) {
        DateFormat dateFormat = new SimpleDateFormat("_HH-mm-ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        String name = methodName + "_" + dateFormat.format(date);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("..\\Screen\\"
                    + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}