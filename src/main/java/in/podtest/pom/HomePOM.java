package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePOM {

    private WebDriver wd;

    public HomePOM(WebDriver wd){
        this.wd = wd;
    }

    private final By yourHeadingHereTxt        = By.xpath("//h1[text()='Your Heading Here']");


    public HomePOM waitFor(){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(yourHeadingHereTxt));
        return this;
    }

    public HomePOM clickProduct(){
        //
        return this;
    }
}
