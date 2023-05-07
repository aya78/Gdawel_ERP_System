package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class StockCountScreen extends HomeScreen {
    private final By Add_stock_count = By.xpath("//button[text()[normalize-space()='جرد المخزن']]");
    private final By OpenWareHouseList = By.xpath("(//button[@title='اختر المخزن...'])[2]");
    private final By SelectWareHouse = By.xpath("//span[text()='الفرع الرئيسي']");
    // //input[@type='submit']
    private final By ClickSave = By.xpath("//input[@type='submit']");

    public StockCountScreen(WebDriver driver) {
        super(driver);
    }
    @Step("open addStockCount ")
    public HomeScreen addStockCount() throws InterruptedException {
         driver.findElement(Add_stock_count).sendKeys(Keys.RETURN);
         driver.findElement(OpenWareHouseList).click();
         driver.findElement(SelectWareHouse).click();
         driver.findElement(ClickSave).click();
        return new HomeScreen(driver);
    }


}
