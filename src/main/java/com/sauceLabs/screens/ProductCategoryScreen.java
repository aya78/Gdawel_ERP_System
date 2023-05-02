package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
//import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCategoryScreen extends HomeScreen{
//    private final Faker faker;

    private final By AddProductCategory = By.xpath("//button[@data-toggle='modal']");
    // //input[@placeholder='Type category name...']
    private final By CategoryName = By.xpath("//input[@placeholder='Type category name...']");
    // //span[text()[normalize-space()='رفع ملف']]
    private final By CategoryImg = By.xpath("//span[text()[normalize-space()='رفع ملف']]");
    // //input[@type='submit']
    private final By SaveCategory = By.xpath("//input[@type='submit']");

    public ProductCategoryScreen(WebDriver driver ) {
        super(driver);
    }

    //    private BufferedImage image;
//
//    public ProductCategoryScreen(WebDriver driver) {
//        super(driver);
//        this.image = ImageIO.read(new File(".png"));
//    }
//    public BufferedImage getImage () {
//        return image;
//    }

    @Step("open product_category page than add new category ")
    public HomeScreen addProductCategory() throws InterruptedException {
        Faker fakeData=new Faker();
        driver.findElement(AddProductCategory).click();
        driver.findElement(CategoryName).sendKeys(fakeData.name().title());
        driver.findElement(CategoryImg).click();
//        driver.findElement(CategoryImg).sendKeys(Faker.instance().file().fileName());
        driver.findElement(SaveCategory).click();

        return new HomeScreen(driver);
    }
}
