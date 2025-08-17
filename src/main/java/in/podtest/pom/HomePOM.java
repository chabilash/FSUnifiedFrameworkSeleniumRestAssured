package in.podtest.pom;

import in.podtest.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePOM extends BasePOM {

    public HomePOM(WebDriver wd){
        super(wd);
        this.wd = wd;
    }

    private By yourHeadingHereTxt        = By.xpath("//h1[text()='Your Heading Here']");

    private By shopKidsButton            = By.xpath("//a/span[text()='Shop kids']");

    private String productLink           = "//div[@class='listing-tem']/div[contains(@class,'product-name')]/a/span[text()='$$$']";

    public By getProductLinkLocator(String productName){
        String updatedProductName = productLink.replace("$$$", productName);
        return By.xpath(updatedProductName);
    }

    public HomePOM waitFor(){
        WaitManager.waitForElementToBeLocated(wd , shopKidsButton);
        return this;
    }

    public HomePOM get(){
        String resourcePath = "/";
        String baseURL = "https://demo.evershop.io";
        String newURL = baseURL.concat(resourcePath);
        get(newURL);
        return this;
    }

    public ProductPOM clickProductName(String productName) {
//        wd.switchTo().alert().accept();
        wd.findElement(getProductLinkLocator(productName)).click();
        return new ProductPOM(wd);
    }
}
