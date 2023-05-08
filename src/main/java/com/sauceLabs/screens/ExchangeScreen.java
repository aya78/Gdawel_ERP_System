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
    private final By ViewExchange = By.xpath("//td[text()='PY000001']");

    @Step(" View Exchange")
    public HomeScreen ViewExchange() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(ViewExchange).click();
        return new HomeScreen(driver);
    }
}
