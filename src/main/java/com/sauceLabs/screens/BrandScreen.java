package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrandScreen  extends HomeScreen{
    public BrandScreen(WebDriver driver) {
        super(driver);
    }
    private final By AddBrand = By.xpath("//button[text()[normalize-space()='أضف علامة تجارية']]");
    private final By AddBrandName = By.xpath("//label[text()='عنوان *']/following::input");
    // image
    private final By uploadImage = By.name("image");

    private final By SaveBrand = By.xpath("//input[@type='submit']");

    @Step(" add Brand")
    public HomeScreen addBrand() throws InterruptedException {
        Faker fakeData=new Faker();
        driver.findElement(AddBrand).click();
        driver.findElement(AddBrandName).sendKeys(fakeData.name().title());
        WebElement chooseFile = driver.findElement(By.name("image"));
        chooseFile.sendKeys("/home/hash-pc-8/Downloads/download/H&M.jpg");
        driver.findElement(SaveBrand).click();

        return new HomeScreen(driver);
    }
}
