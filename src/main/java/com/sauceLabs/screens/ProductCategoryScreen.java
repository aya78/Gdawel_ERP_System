package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
//import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductCategoryScreen extends HomeScreen{
//    private final Faker faker;
    /***************************************  //button[@data-toggle='modal']       */
    private final By AddProductCategory = By.xpath("//button[@data-toggle='modal']");
    // //input[@placeholder='Type category name...']
    private final By CategoryName = By.xpath("//input[@placeholder='Type category name...']");
    // //span[text()[normalize-space()='رفع ملف']]
    private final By CategoryImg = By.id("input-646b141c5631b");
    // //input[@type='submit']
    private final By SaveCategory = By.xpath("//input[@type='submit']");

    public ProductCategoryScreen(WebDriver driver ) {
        super(driver);
    }


    @Step("open product_category page than add new category ")
    public HomeScreen addProductCategory() throws InterruptedException {
        Faker fakeData=new Faker();
        driver.findElement(AddProductCategory).click();
         String s =fakeData.name().title();
        driver.findElement(CategoryName).sendKeys(s);
        System.out.println(s);
//        driver.findElement(CategoryImg).click();
//        driver.findElement(CategoryImg).sendKeys(Faker.instance().file().fileName());
//        uploadImage("/home/hash-pc-8/Downloads/chanel.png");
        Thread.sleep(1000);

//        driver.findElement(CategoryImg).sendKeys("/home/hash-pc-8/Downloads/chanel.png");
        WebElement chooseFile = driver.findElement(By.name("image"));
        chooseFile.sendKeys("/home/hash-pc-8/Downloads/shein.png");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated((By) chooseFile));
        driver.findElement(SaveCategory).click();

        return new HomeScreen(driver);
    }
}
