package in.podtest.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitManager {

    public static void waitForElementToBeLocated(WebDriver wd, By elementToBeLocated){

        FluentWait wait = new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(elementToBeLocated));

    }

    public static void waitForElementToHaveAttributeWithSpecificValue(WebDriver wd, WebElement eleLocator, String attName, String attValue){

        FluentWait wait = new FluentWait(wd);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.attributeContains(eleLocator,attName,attValue));

    }
}
