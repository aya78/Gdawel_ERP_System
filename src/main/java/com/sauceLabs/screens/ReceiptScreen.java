package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReceiptScreen extends HomeScreen{
    public ReceiptScreen(WebDriver driver) {
        super(driver);
    }
    private final By ViewReceipt = By.className("sorting_1 dtr-control");

    @Step(" View Receipt")
    public HomeScreen ViewReceipt() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(ViewReceipt).click();
        return new HomeScreen(driver);
    }
}
