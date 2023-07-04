package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QuotationScreen extends HomeScreen {
    public QuotationScreen(WebDriver driver) {
        super(driver);
    }
    //div[@id='data-length-operations']//a[1]

    // https://gdawel.app/dashboard/quotations/create
//    private final By AddQuotation = By.xpath("//a=[@href='https://gdawel.app/dashboard/quotations/create']");
    private final By OpenPurchaseQuotation = By.xpath("//div[@data-type='purchases']");
    // //div[@class='search-box input-group']//input[1]
//    private final By ScanProductButton = By.xpath("//label[text()='امسح المنتج بالباركود أو ادخل كود المنتج']/following::input");
    private final By ScanProductButton = By.id("productcodeSearch");

    private final By SaveInvoiceButton = By.cssSelector("input#submit-button");
    // input#submit-button
    //submit-button

    // table#quotation-table>tbody>tr>td:nth-of-type(2)>a



    @Step(" add Sale Quotation Invoice")
    public HomeScreen addSaleQuotationInvoice() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://gdawel.app/dashboard/quotations/create");
//        driver.findElement(AddQuotation).click();
        driver.findElement(ScanProductButton).sendKeys("58554172");
//        wait.until(ExpectedConditions.elementToBeClickable(ScanProductButton));

        Actions a = new Actions(driver);
        Thread.sleep(6000);

        //scroll down a page
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        //scroll up a page
//        a.sendKeys(Keys.PAGE_UP).build().perform();
        Thread.sleep(6000);
        driver.findElement(SaveInvoiceButton).click();
        return new HomeScreen(driver);
    }
    @Step(" add Purchase Quotation Invoice")
    public HomeScreen addPurchaseQuotationInvoice() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://gdawel.app/dashboard/quotations/create");
        driver.findElement(OpenPurchaseQuotation).click();
        driver.findElement(ScanProductButton).sendKeys("58554172");
//        wait.until(ExpectedConditions.elementToBeClickable(ScanProductButton));
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(600);

        driver.findElement(SaveInvoiceButton).click();
        return new HomeScreen(driver);
    }
}
