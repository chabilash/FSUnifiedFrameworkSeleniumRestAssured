package in.podtest.pom.components;

import in.podtest.pom.AboutUsPOM;
import in.podtest.pom.CartPOM;
import in.podtest.pom.HomePOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPOM {

    private WebDriver wd;

    public HeaderPOM(WebDriver wd){
        this.wd = wd;
    }

    private By shopDropdown       = By.xpath("//li[@class='relative group']/a[contains(text(),'Shop')]");

    private By aboutUsLink        = By.xpath("");

    private By appIcon            = By.xpath("");

    private By searchIcon         = By.xpath("//a[@class='search-icon']");

    private By cartIcon           = By.xpath("//a[@class='mini-cart-icon']");

    private By accountIcon        = By.xpath("//a[contains(@href,'.account')]");

    public AboutUsPOM clickAboutUsLink(){
        wd.findElement(appIcon).click();
        return new AboutUsPOM(wd);
    }

    public HomePOM clickAppIcon(){
        wd.findElement(appIcon).click();
        return new HomePOM(wd);
    }

    public CartPOM clickCartIcon(){
        wd.findElement(cartIcon).click();
        return new CartPOM(wd);
    }
}
