package in.podtest;

import in.podtest.pom.HomePOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class E2ETestFlow {


    WebDriver wd;
    String email = "chabilash@gmail.com";
    String password = "Note@8008";
    String expecUsername = "Abilash Chintalacheruvula";

    @BeforeTest
    public void preStep(){

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.get("https://demo.evershop.io/account/login");
    }


    @Test
    public void testLoginFlow() {

        LoginPOM loginPage = new LoginPOM(wd);

        loginPage.get().
                fillUserName(email).
                fillPassword(password).
                clickSubmit().
                waitFor();

        String expectedURL = "https://demo.evershop.io/";
        String actualURL = wd.getCurrentUrl();
        Assert.assertEquals(actualURL , expectedURL);

    }

    @AfterTest
    public void postSteps(){
        wd.quit();
    }


}
