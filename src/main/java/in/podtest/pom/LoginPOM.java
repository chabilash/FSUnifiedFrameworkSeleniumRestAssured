package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {

    private WebDriver wd;

    public LoginPOM(WebDriver wd){
        this.wd = wd;
    }

    private final By emailTB            = By.xpath("//input[@name='email']");

    private final By passwordTB         = By.xpath("//input[@name='password']");

    private final By submitBtn          = By.xpath("//button[@type='submit']");

    public LoginPOM fillUserName(String emailID){
        wd.findElement(emailTB).sendKeys(emailID);
        return this;
    }

    public LoginPOM fillPassword(String password){
        wd.findElement(passwordTB).sendKeys(password);
        return this;
    }

    public HomePOM clickSubmit(){
        wd.findElement(submitBtn).click();
        return new HomePOM(wd);
    }

    public LoginPOM fillCredentials(String emailID, String password){
        wd.findElement(emailTB).sendKeys(emailID);
        wd.findElement(passwordTB).sendKeys(password);
        return this;
    }

    public LoginPOM get(){
        String resourcePath = "/account/login";
        String baseURL = "https://demo.evershop.io";
        String newURL = baseURL.concat(resourcePath);
        wd.get(newURL);
        return this;
    }

}
