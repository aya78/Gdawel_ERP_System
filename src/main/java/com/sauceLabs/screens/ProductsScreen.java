package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
//import lombok.var;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;


import java.util.Random;



public class ProductsScreen extends HomeScreen{
    int[] arr = {1489426,51582783,6922869,4026422};
    private final By AddProduct = By.xpath("(//a[@href='https://gdawel.app/dashboard/products/create'])[2]");
    // /html/body/div[2]/div[6]/div/section/form/div/div/div[1]/div/div/div/div[1]/div/input
    private final By ProductName = By.id("name");
    private final By Barcode = By.xpath("//input[@class='form-control rounded-right']");
//private final By Barcode = By.id("genbutton");
//    private final By openBrandList  = By.cssSelector("form#product-form>div>div>div>div>div>div>div:nth-of-type(2)>div>div:nth-of-type(2)>div>button>div>div>div");
//    private final By selectBrand = By.xpath("(//ul[@role='presentation']//a)[2]");
    private final By productCost = By.xpath("//input[@min='0.001']");
    private final By productPrice = By.xpath("(//input[@min='0.001'])[2]");
//    private final By openUnitList  = By.xpath("//div[text()='اختر وحدة المنتج...']");
//    private final By selectUnit = By.cssSelector("a#bs-select-8-1>span:nth-of-type(2)");
    // //input[@class='btn btn-primary']
  private final By ProductImage = By.xpath("//a[@class='dz-hidden-input']");

    private final By clickSave = By.xpath("//input[@value='حفظ']");
    private final By addComboProduct = By.cssSelector("#first > div > div > div:nth-child(3) > div");
    private final By attachProductINAddCombo = By.name("product_code_name");
    private final By ViewProduct = By.xpath("//a[@class='text-dark']");
    private static WebElement element=null;
    // name -> file
    private final By OpenImportProducts = By.cssSelector("#data-length-operations > a.btn.btn-warning.mb-2");
    //    private final By openUnitList  = By.xpath("//div[text()='اختر وحدة المنتج...']");
//    private final By selectUnit = By.cssSelector("a#bs-select-8-1>span:nth-of-type(2)");
    // //input[@class='btn btn-primary']
    private final By upload_file = By.name("file");
    private final By saveImport = By.cssSelector("#importProduct > div > div > form > div.modal-body.mx-4 > div.d-flex.justify-content-between.gap-2 > div > input");

    public static WebElement selectBrand(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.name("brand_id"));
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
        element =driver.findElement(By.name("unit_id"));
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
        String v =fakeData.name().name();
        driver.findElement(ProductName).sendKeys(v);
        System.out.println(v);
        driver.findElement(Barcode).sendKeys(fakeData.number().digits(8));
        selectBrand(driver);
//        driver.findElement(openBrandList).click();
//        driver.findElement(selectBrand).click();
        driver.findElement(productCost).sendKeys(""+cost);
        driver.findElement(productPrice).sendKeys(""+cost+20);
        selectUnit(driver);
        Actions a = new Actions(driver);
        //scroll down a page
//        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        //scroll up a page
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        WebElement choose_img = driver.findElement(By.className("dz-hidden-input"));
        choose_img.sendKeys("/home/hash-pc-8/Downloads/tablet.jpeg");
        Thread.sleep(4000);
//        driver.findElement(openUnitList).click();
//        driver.findElement(selectUnit).click();
        driver.findElement(clickSave).click();
/***************************************************************** import products Done ****************************************************************************/
//        driver.findElement(OpenImportProducts).click();

//        WebElement chooseFile = driver.findElement(By.name("file"));
//        chooseFile.sendKeys("/home/hash-pc-8/Downloads/sample_products (6).xlsx");
//        driver.findElement(saveImport).click();
//        Thread.sleep(1000);
        driver.findElement(AddProduct).click();
        driver.findElement(addComboProduct).click();
        driver.findElement(ProductName).sendKeys(v);
        System.out.println(v);
        driver.findElement(Barcode).sendKeys(fakeData.number().digits(8));
        driver.findElement(productPrice).sendKeys(""+cost+20);
        driver.findElement(attachProductINAddCombo).sendKeys("1000024");
        driver.findElement(clickSave).click();
        driver.findElement(ViewProduct).click();
        return new HomeScreen(driver);
    }



}
