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

    String email = "chabilash.qa@gmail.com";
    String password = "P@ssword";
    String expecUsername = "Abilash Chintalacheruvula";
    String productName = "Nike court vision low";

    @BeforeTest
    public void preStep(){

        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.get("https://demo.evershop.io/account/login");
    }


    @Test
    public void testLoginFlow() {

        LoginPOM loginPage = new LoginPOM(wd);

        loginPage.get().
                fillUserName(email).
                fillPassword(password).
                clickSubmit().
                waitFor().getHeader().clickCartIcon();

       // String expectedURL = "https://demo.evershop.io/";
        //String actualURL = wd.getCurrentUrl();
        //Assert.assertEquals(actualURL , expectedURL);

    }

    @Test
    public void testProductOrderFlow()  {

        LoginPOM loginPage = new LoginPOM(wd);

        loginPage
                .get()
                .fillUserName(email)
                .fillPassword(password)
                .clickSubmit()
                .waitFor()
                .clickProductName(productName)
                .waitFor()
                .selectItemSize("X")
                .selectItemColor("White")
                .fillItemQty("1")
                .clickAddToCartBtn()
                .clickViewCartBtn();
    }

    @AfterTest
    public void postSteps(){
//        wd.quit();
    }


}
