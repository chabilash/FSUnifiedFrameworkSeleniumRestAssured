package in.podtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class E2ETestFlow {

    @Test
    public void tc1() throws InterruptedException {

        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://demo.evershop.io");
        Thread.sleep(2000);
        //wd.quit();
    }

    @Test
    public void tc2() throws InterruptedException {

        WebDriver wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://demo.evershop.io");
        Thread.sleep(2000);
        //wd.quit();
    }
}
