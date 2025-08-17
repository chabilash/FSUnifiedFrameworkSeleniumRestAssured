package in.podtest.pom;

import in.podtest.util.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class ProductPOM extends BasePOM{

    private By addToCartButton = By.xpath("//button/span[text()='ADD TO CART']");
    private String itemSizeCB  = "//ul[contains(@class,'variant-option-list')]/li/a[text()='$$$']";
    private String itemColorCB = "//ul[contains(@class,'variant-option-list')]/li/a[text()='$$$']";
    private By  qtyTB          = By.xpath("//input[@name='qty']");
    private By viewCartBtn     = By.xpath("//a[@class='add-cart-popup-button' and contains(text(),'VIEW CART')]");

    public ProductPOM(WebDriver wd){
        super(wd);
    }

    public By itemSizeCBLocator(String sizeName){
        String updatedItemSizeCB = itemSizeCB.replace("$$$",sizeName);
        return By.xpath(updatedItemSizeCB);
    }

    public By itemColorCBLocator(String colorName){
        String updatedColorCB = itemColorCB.replace("$$$",colorName);
        return By.xpath(updatedColorCB);
    }

    public ProductPOM waitFor(){
        WaitManager.waitForElementToBeLocated(wd , addToCartButton);
        return this;
    }

    public ProductPOM selectItemSize(String itemSize)  {
        By ele = itemSizeCBLocator(itemSize);
        wd.findElement(ele).click();
        WaitManager.waitForElementToHaveAttributeWithSpecificValue(wd, wd.findElement(ele).findElement(By.xpath("//parent::li")), "class", "selected" );
        return this;
    }

    public ProductPOM selectItemColor(String itemColor){
        By ele = itemColorCBLocator(itemColor);
//        wd.findElement(colorEle).click();
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.getElementById('ele').click();");
        WaitManager.waitForElementToHaveAttributeWithSpecificValue(wd, wd.findElement(ele).findElement(By.xpath("//parent::li")), "class", "selected");
        return this;
    }

    public ProductPOM fillItemQty(String qty){
        wd.findElement(qtyTB).clear();
        wd.findElement(qtyTB).sendKeys(qty);
        return this;
    }

    public ProductPOM clickAddToCartBtn(){
        wd.findElement(addToCartButton).click();
        WaitManager.waitForElementToBeLocated(wd, viewCartBtn);
        return this;
    }

    public CartPOM clickViewCartBtn(){
        wd.findElement(viewCartBtn).click();
        return new CartPOM(wd);
    }
}
