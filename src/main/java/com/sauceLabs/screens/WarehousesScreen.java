package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WarehousesScreen  extends HomeScreen{
    public WarehousesScreen(WebDriver driver) {
        super(driver);
    }
    // //a[@data-target='#createModal']
    public  String random = RandomStringUtils.random(4, true, false);
    public  String randomNum = RandomStringUtils.random(10, false, true);
    private final By AddWareHouse = By.xpath("//a[@data-target='#createModal']");
    private final By AddWareHouseName = By.xpath("//input[@placeholder='Type WareHouse Name...']");

    private final By AddWareHousePhone = By.xpath("//label[text()='رقم الهاتف']/following::input");
    private final By AddWareHouseEmail = By.xpath("//input[@placeholder='example@gdawel.app']");
    private final By AddWareHouseAddress = By.xpath("//label[text()='عنوان']/following::textarea");
    private final By SaveWareHouse = By.xpath("//input[@type='submit']");
    private final By ViewWareHouse = By.xpath("//a[@href='https://gdawel.app/dashboard/warehouse/1']");
    @Step(" add and view WareHouses ")
    public HomeScreen addAndViewWareHouses() throws InterruptedException {
        Faker fakeData=new Faker();


        driver.findElement(AddWareHouse).click();
        driver.findElement(AddWareHouseName).sendKeys(""+random);
        driver.findElement(AddWareHousePhone).sendKeys("0"+randomNum);
        driver.findElement(AddWareHouseEmail).sendKeys(random+"@gmail.com");
        driver.findElement(AddWareHouseAddress).sendKeys(""+fakeData.address().fullAddress());
        driver.findElement(SaveWareHouse).click();
        driver.findElement(ViewWareHouse).click();
        return new HomeScreen(driver);
    }




}
