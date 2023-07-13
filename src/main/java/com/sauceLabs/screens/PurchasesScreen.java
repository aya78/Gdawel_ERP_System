package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PurchasesScreen extends HomeScreen {
    public PurchasesScreen(WebDriver driver) {
        super(driver);
    }
    // 1000069,1000068,1000067,1000066,1000065,1000064,1000063,1000062,1000061
    int arr[]={1000085,1000084,1000083,1000082};

    private final By AddInvoiceButton = By.xpath("//a[@href='https://gdawel.app/dashboard/purchases/create']");
    // //div[@class='search-box input-group']//input[1]
//    private final By ScanProductButton = By.xpath("//div[@class='search-box input-group']//input[1]");
    /***************************************************************************************************************************************/
    // productcodeSearch
    private final By ScanProductButton = By.id("productcodeSearch");

    // (//div[contains(@class,'d-flex align-items-center')]//button)[3]
    // //input[@class='form-control qty']
    /*************************************************************************************************************************************/
    private final By EditQty = By.xpath("//input[@class='form-control qty']");
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
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        Faker fakeData=new Faker();
//        driver.findElement(OpenPurchases).click();
        driver.get("https://gdawel.app/dashboard/purchases/create");
//        driver.findElement(AddInvoiceButton).click();
        for(int i = 0 ;i < arr.length ; i++ ){
            driver.findElement(ScanProductButton).sendKeys(""+arr[i]);
            Thread.sleep(10000);
            driver.findElement(EditQty).sendKeys("60");
            Thread.sleep(15000);
        }
//
//        driver.findElement(EditQty).sendKeys(Keys.BACK_SPACE);
//        driver.findElement(EditQty).sendKeys("60");
//        Thread.sleep(20000);
////        wait.until(ExpectedConditions.elementToBeSelected(ScanProductButton));
       // Thread.sleep(20000);
        driver.findElement(SaveInvoiceButton).click();
        return new HomeScreen(driver);
    }
    @Step(" add  return Purchase Invoice")
    public HomeScreen addReturnPurchaseInvoice() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(VIewInvoiceButton).click();
        driver.findElement( ClickAction).click();
        driver.findElement(AddReturnPurchase).click();
        driver.findElement(SelectProduct).click();
        driver.findElement(SaveButton).click();

        return new HomeScreen(driver);
    }
}
