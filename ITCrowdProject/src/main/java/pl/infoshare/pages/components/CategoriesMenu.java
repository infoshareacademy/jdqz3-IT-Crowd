package pl.infoshare.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;
import pl.infoshare.pages.BasePage;

public class CategoriesMenu {
    private String url;

    public String switchToPage(String categories) {
        switch (categories) {
            case "Handbags": {
                this.url = "http://demo.shopizer.com:8080/shop/category/handbags.html/ref=c:1";
                break;
            }
            case "Beach bags": {
                this.url = "http://demo.shopizer.com:8080/shop/category/beachbags.html/ref=c:52,50";
                break;
            }
            case "Laptop bags": {
                this.url = "http://demo.shopizer.com:8080/shop/category/laptop-bags.html/ref=c:50,51";
                break;
            }
            case "Bags": {
                this.url = "http://demo.shopizer.com:8080/shop/category/bags.html/ref=c:51,52";
                break;
            }
        }
        return this.url;
    }
}
