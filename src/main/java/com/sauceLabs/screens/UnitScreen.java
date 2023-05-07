package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UnitScreen extends HomeScreen{
    public UnitScreen(WebDriver driver) {
        super(driver);
    }
    public  String randomNum = RandomStringUtils.random(8, false, true);

    private final By AddUnit = By.xpath("(//a[contains(@class,'btn btn-primary')])[2]");
    private final By AddUnitName = By.xpath("//input[@name='unit_name']");
    private final By AddUnitCode = By.xpath("//input[@name='unit_code']");

    private final By SaveUnit = By.xpath("//div[@class='form-group operation_value']/following-sibling::input[1]");

    @Step(" add Unit")
    public HomeScreen addUnit() throws InterruptedException {
        Faker fakeData=new Faker();
        driver.findElement(AddUnit).click();
        driver.findElement(AddUnitCode).sendKeys(""+randomNum);
        driver.findElement(AddUnitName).sendKeys(fakeData.name().title());
        driver.findElement(SaveUnit).click();
        return new HomeScreen(driver);
    }
}
