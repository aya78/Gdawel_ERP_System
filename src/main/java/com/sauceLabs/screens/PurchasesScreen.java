package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchasesScreen extends HomeScreen {
    public PurchasesScreen(WebDriver driver) {
        super(driver);
    }
    // 1000069,1000068,1000067,1000066,1000065,1000064,1000063,1000062,1000061
    // ,58554172,53027350,74684131,100002,4155632
    int arr[]={42288482};
    private final By AddInvoiceButton = By.xpath("//a[@href='https://gdawel.app/dashboard/purchases/create']");
    // //div[@class='search-box input-group']//input[1]
//    private final By ScanProductButton = By.xpath("//div[@class='search-box input-group']//input[1]");
    /***************************************************************************************************************************************/
    // productcodeSearch
    private final By ScanProductButton = By.id("productcodeSearch");

    // (//div[contains(@class,'d-flex align-items-center')]//button)[3]
    // //input[@class='form-control qty']
    /****************************************************************Edit Quantity *********************************************************************/
    /*************************************************************************************************************************************/

    private final By SaveInvoiceButton = By.xpath("(//div[contains(@class,'d-flex align-items-center')]//button)[3]");
    private final By VIewInvoiceButton = By.xpath("//tr[@role='row']//td");
   private final By ClickAction = By.xpath("//div[@role='group']//button[1]");
    private final By AddReturnPurchase = By.xpath("//span[text()='إنشاء فاتورة إسترجاع']");
    /*************************************************************************************************************************************/

    private final By SelectProduct = By.xpath("//input[@type='checkbox']");
    private final By SaveButton = By.cssSelector("input#submit-button");


    @Step(" add Purchase Invoice")
    public HomeScreen addPurchaseInvoice() throws InterruptedException {
        Faker fakeData=new Faker();
        driver.get("https://gdawel.app/dashboard/purchases/create");
        /** when user create a purchase invoice for more than one product **********************/
//        for(int i = 0 ;i < arr.length ; i++ ){
//            driver.findElement(ScanProductButton).sendKeys(""+arr[i]);
//            Thread.sleep(10000);
//            driver.findElement(EditQty).sendKeys("60");
//            Thread.sleep(15000);
//        }
        /** ****************************************************************************************/
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(ScanProductButton));
        driver.findElement(ScanProductButton).sendKeys(""+Barcode);
        new WebDriverWait(driver,Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(EditQty));
//            driver.findElement(EditQty).sendKeys("60");
//            Thread.sleep(15000);
////
//        driver.findElement(EditQty).sendKeys(Keys.BACK_SPACE);
////        wait.until(ExpectedConditions.elementToBeSelected(ScanProductButton));
        driver.findElement(SaveInvoiceButton).click();
        return new HomeScreen(driver);
    }
    @Step(" add  return Purchase Invoice")
    public HomeScreen addReturnPurchaseInvoice() throws InterruptedException {

        driver.findElement(VIewInvoiceButton).click();
        driver.findElement( ClickAction).click();
        driver.findElement(AddReturnPurchase).click();
        driver.findElement(SelectProduct).click();
        driver.findElement(SaveButton).click();

        return new HomeScreen(driver);
    }
}
