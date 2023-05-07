package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QtyAdjustmentScreen extends HomeScreen {
    int[] arr = {1489426,65333756,6922869,4026422};
    private final By AddQtyAdjustment = By.xpath("//a[@href='https://gdawel.app/dashboard/qty_adjustment/create']");
    // //input[@placeholder='Type category name...']

    // //input[@type='submit']
//    private final By SaveCategory = By.xpath("//input[@type='submit']");
    private final By OpenWareHouseList = By.xpath("(//button[@title='اختر المخزن...'])[2]");
    // (//a[@class='dropdown-item'])[2]
    private final By SelectWareHouse = By.xpath("//span[text()='الفرع الرئيسي']");
    // //input[@placeholder='قم بالمسح أو اكتب كود المنتج ...']
    private final By SelectProduct = By.xpath("//input[@placeholder='قم بالمسح أو اكتب كود المنتج ...']");
// //input[@class='form-control qty']
    private final By ChangQuantity = By.xpath("//input[@class='form-control qty']");
    // //select[@class='form-control act-val']
    private final By SelectOperation = By.xpath("//select[@class='form-control act-val']");
// //input[contains(@class,'btn btn-primary')]
   private final By ClickSave = By.xpath("//input[contains(@class,'btn btn-primary')]");

    public QtyAdjustmentScreen(WebDriver driver ) {
        super(driver);
    }

    @Step("open QtyAdjustment ")
    public HomeScreen addQty_adjustment() throws InterruptedException {
        Faker fakeData=new Faker();
        driver.findElement(AddQtyAdjustment).click();
        driver.findElement(OpenWareHouseList).click();
        driver.findElement(SelectWareHouse).click();
        driver.findElement(SelectProduct).sendKeys(""+arr[1]);
        driver.findElement(ChangQuantity).sendKeys(""+50);
        driver.findElement(SelectOperation).click();
        driver.findElement(ClickSave).click();
        return new HomeScreen(driver);
    }
}
