package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SalesScreen extends HomeScreen{

    public SalesScreen(WebDriver driver) {
        super(driver);
    }
    private final By AddInvoiceButton = By.cssSelector("div#data-length-operations>a");
    private final By ScanProductButton = By.xpath("//input[@placeholder='قم بالمسح أو اكتب كود المنتج ...']");
    private final By EditQty = By.xpath("//input[@class='form-control qty']");
    private final By SaveInvoiceButton = By.xpath("//input[@type='submit']");
    private final By VIewInvoiceButton = By.xpath("//tr[@role='row']//td");
    private final By ClickAction = By.cssSelector("div#dropGroup2>button");
    private final By AddReturnSale = By.xpath("//a[contains(@class,'dropdown-item d-flex')]/following-sibling::a[1]");
    private final By SelectProduct = By.xpath("//input[@class='is-return']/following-sibling::span[1]");
    private final By SaveButton = By.xpath("//input[@value='حفظ']");
    // //button[@data-toggle='dropdown']//i
    // //button[text()=' إضافة التسليم']
    // //div[text()='Nothing selected']
    // //a[@id='bs-select-12-0']
    // button#submitBtnConfirm


    @Step(" add Sale Invoice")
    public HomeScreen addSaleInvoice() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        Faker fakeData=new Faker();
//        driver.findElement(OpenSales).click();
        driver.findElement(AddInvoiceButton).click();
        driver.findElement(ScanProductButton).sendKeys("4155632");
//        wait.until(ExpectedConditions.elementToBeSelected(ScanProductButton));
        driver.findElement(EditQty).sendKeys("2");
        driver.findElement(SaveInvoiceButton).click();
        return new HomeScreen(driver);
    }
    @Step(" add  return Sale Invoice")
    public HomeScreen addReturnSaleInvoice() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(VIewInvoiceButton).click();
        driver.findElement( ClickAction).click();
        driver.findElement(AddReturnSale).click();
        driver.findElement(SelectProduct).click();
        driver.findElement(SaveButton).click();

        return new HomeScreen(driver);
    }
    @Step(" add New Delivery")
    public HomeScreen AddNewDelivery() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));

        return new HomeScreen(driver);
    }
}
