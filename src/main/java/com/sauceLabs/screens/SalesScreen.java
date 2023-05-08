package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private final By ClickActionInViewInvoice = By.cssSelector("div#dropGroup2>button");
    private final By AddReturnSale = By.xpath("//a[contains(@class,'dropdown-item d-flex')]/following-sibling::a[1]");
    private final By SelectProduct = By.xpath("//input[@class='is-return']/following-sibling::span[1]");
    private final By SaveButton = By.xpath("//input[@value='حفظ']");
    // //button[@data-toggle='dropdown']//i
    private final By ClickOnAction = By.xpath("//button[@data-toggle='dropdown']//i");
    private final By AddDelivery = By.xpath("//button[text()=' إضافة التسليم']");
    private final By ClickOnStatus = By.xpath("//div[text()='Nothing selected']");
    private final By SelectInProgress = By.xpath("//a[@id='bs-select-12-0']");
    private final By SaveDelivery = By.cssSelector("button#submitBtnConfirm");
    // //tr[@class='delivery-link odd']//a
    private final By ViewDelivery = By.xpath("//tr[@class='delivery-link odd']//a");



    @Step(" add Sale Invoice")
    public HomeScreen addSaleInvoice() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        Faker fakeData=new Faker();
//        driver.findElement(OpenSales).click();
        driver.findElement(AddInvoiceButton).click();
        Thread.sleep(1000);

        driver.findElement(ScanProductButton).sendKeys(Keys.BACK_SPACE);

        driver.findElement(ScanProductButton).sendKeys("4155632");
        Thread.sleep(1000);

//        wait.until(ExpectedConditions.elementToBeClickable(ScanProductButton));
        driver.findElement(EditQty).sendKeys("2");
        driver.findElement(SaveInvoiceButton).click();
        return new HomeScreen(driver);
    }
    @Step(" add  return Sale Invoice")
    public HomeScreen addReturnSaleInvoice() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(VIewInvoiceButton).click();
        driver.findElement( ClickActionInViewInvoice).click();
        driver.findElement(AddReturnSale).click();
        driver.findElement(SelectProduct).click();
        driver.findElement(SaveButton).click();

        return new HomeScreen(driver);
    }
    @Step(" add New Delivery")
    public HomeScreen AddNewDelivery() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        driver.findElement(ClickOnAction).click();
        driver.findElement(AddDelivery).click();
        driver.findElement(ClickOnStatus).click();
        driver.findElement(SelectInProgress).click();
        driver.findElement(SaveDelivery).click();
        driver.findElement(ViewDelivery).click();
        return new HomeScreen(driver);
    }
}
