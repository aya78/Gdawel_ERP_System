package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.Random;

public class StockCountScreen extends HomeScreen {
    private final By Add_stock_count = By.xpath("//button[text()[normalize-space()='جرد المخزن']]");
//    private final By OpenWareHouseList = By.xpath("(//button[@title='اختر المخزن...'])[2]");
//    private final By SelectWareHouse = By.xpath("//span[text()='الفرع الرئيسي']");
    // //input[@type='submit']
    private final By ClickSave = By.xpath("//input[@type='submit']");
    //warehouse_id
    private static WebElement element=null;

    public static WebElement selectWareHouse(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.id("warehouse_id"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#warehouse_id > option")).size();
        System.out.println(dropdown_value);
        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);
        skills.selectByIndex(index);
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }

    public StockCountScreen(WebDriver driver) {
        super(driver);
    }
    @Step("open addStockCount ")
    public HomeScreen addStockCount() throws InterruptedException {
         driver.findElement(Add_stock_count).sendKeys(Keys.RETURN);
//         driver.findElement(OpenWareHouseList).click();
//         driver.findElement(SelectWareHouse).click();
        selectWareHouse(driver);
         driver.findElement(ClickSave).click();
        return new HomeScreen(driver);
    }


}
