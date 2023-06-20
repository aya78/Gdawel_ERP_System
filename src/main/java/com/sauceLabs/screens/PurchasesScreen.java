package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchasesScreen extends HomeScreen {
    public PurchasesScreen(WebDriver driver) {
        super(driver);
    }

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
        driver.findElement(ScanProductButton).sendKeys("4155632");
//        wait.until(ExpectedConditions.elementToBeSelected(ScanProductButton));
        driver.findElement(EditQty).sendKeys("2");
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
