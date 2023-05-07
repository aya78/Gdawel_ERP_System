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
    private final By OpenPurchases = By.cssSelector("li#purchase-list-menu>a");

    private final By AddInvoiceButton = By.cssSelector("div#data-length-operations>a>img");
    // //div[@class='search-box input-group']//input[1]
    private final By ScanProductButton = By.xpath("//div[@class='search-box input-group']//input[1]");
// (//div[contains(@class,'d-flex align-items-center')]//button)[3]
    // //input[@class='form-control qty']
    private final By EditQty = By.xpath("//input[@class='form-control qty']");

    private final By SaveInvoiceButton = By.xpath("(//div[contains(@class,'d-flex align-items-center')]//button)[3]");


    @Step(" add Purchase Invoice")
    public HomeScreen addPurchaseInvoice() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
//        wait.until(ExpectedConditions.invisibilityOfAllElements());

        Faker fakeData=new Faker();
        driver.findElement(OpenPurchases).click();
        driver.findElement(AddInvoiceButton).click();
        driver.findElement(ScanProductButton).sendKeys("4155632");
//        wait.until(ExpectedConditions.elementToBeSelected(ScanProductButton));
        driver.findElement(EditQty).sendKeys("2");

        driver.findElement(SaveInvoiceButton).click();
        return new HomeScreen(driver);
    }
}
