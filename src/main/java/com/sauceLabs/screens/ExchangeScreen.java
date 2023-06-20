package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExchangeScreen extends HomeScreen{
    public ExchangeScreen(WebDriver driver) {
        super(driver);
    }
    private final By ViewExchange = By.className("sorting_1 dtr-control");

    @Step(" View Exchange")
    public HomeScreen ViewExchange() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(ViewExchange).click();
        return new HomeScreen(driver);
    }
}
