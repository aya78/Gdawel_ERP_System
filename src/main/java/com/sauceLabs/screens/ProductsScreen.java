package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


import java.util.Random;



public class ProductsScreen extends HomeScreen{
    int[] arr = {1489426,51582783,6922869,4026422};
    private final By AddProduct = By.xpath("(//a[@href='https://gdawel.app/dashboard/products/create'])[2]");
    // /html/body/div[2]/div[6]/div/section/form/div/div/div[1]/div/div/div/div[1]/div/input
    private final By ProductName = By.id("name");
//    private final By Barcode = By.xpath("//input[@class='form-control rounded-right']");
private final By Barcode = By.id("genbutton");
    private final By openBrandList  = By.cssSelector("form#product-form>div>div>div>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div>button>div>div>div");
    private final By selectBrand = By.xpath("(//ul[@role='presentation']//a)[2]");
    private final By productCost = By.xpath("//input[@min='0.001']");
    private final By productPrice = By.xpath("(//input[@min='0.001'])[2]");
    private final By openUnitList  = By.xpath("//div[text()='اختر وحدة المنتج...']");
    private final By selectUnit = By.cssSelector("a#bs-select-8-1>span:nth-of-type(2)");
    // //input[@class='btn btn-primary']
    private final By clickSave = By.xpath("//input[@value='حفظ']");
    private final By ViewProduct = By.xpath("//a[@class='text-dark']");
    private static WebElement element=null;


    public static WebElement selectBrand(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.id("brand_id"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#product-form > div > div > div.col-xl-9.col-lg-12 > div > div > div > div.col-sm-6.mb-3.brand > div > div:nth-child(2) > div > select > option")).size();
        System.out.println(dropdown_value);
        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);
        skills.selectByIndex(index);
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }
    public static WebElement selectUnit(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.id("unit_id"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#unit > div > div:nth-child(1) > div > div:nth-child(2) > div > select > option" )).size();
        System.out.println(dropdown_value);
        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);
        skills.selectByIndex(index);
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }
    public ProductsScreen(WebDriver driver) {
        super(driver);
    }

    @Step("open product page than add And View Product")
    public HomeScreen addAndViewProductPage() throws InterruptedException {
        Faker fakeData=new Faker();
        int price = Integer.parseInt(RandomStringUtils.random(3, false, true));
        int cost = Integer.parseInt(fakeData.number().digits(3));

        driver.findElement(AddProduct).click();
        driver.findElement(ProductName).sendKeys(fakeData.name().fullName());
        driver.findElement(Barcode).sendKeys(fakeData.number().digits(8));
        selectBrand(driver);
//        driver.findElement(openBrandList).click();
//        driver.findElement(selectBrand).click();
        driver.findElement(productCost).sendKeys(""+cost);
        driver.findElement(productPrice).sendKeys(""+cost+20);
        selectUnit(driver);
//        driver.findElement(openUnitList).click();
//        driver.findElement(selectUnit).click();
        driver.findElement(clickSave).click();
        driver.findElement(ViewProduct).click();
        return new HomeScreen(driver);
    }



}
