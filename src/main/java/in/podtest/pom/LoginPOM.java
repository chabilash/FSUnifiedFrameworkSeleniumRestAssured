package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM extends BasePOM{

    public LoginPOM(WebDriver wd){
        super(wd);

    }

    public LoginPOM get(){

        String resourcePath = "/account/login";
        String baseURL = "https://demo.evershop.io";
        String newURL = baseURL.concat(resourcePath);
        get(newURL);
        return this;
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

}
