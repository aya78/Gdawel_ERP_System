package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

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
    private final By SelectProduct = By.id("productcodeSearch");
// //input[@class='form-control qty']
    private final By ChangQuantity = By.xpath("//input[@class='form-control qty']");
    // //select[@class='form-control act-val']
    //
    // //td[@class='action']//select[1]
    private final By ClickOperation = By.cssSelector("#myTable > tbody > tr > td.action");
    // //select[@class='form-control act-val']
// //th[text()='المجموع']/following-sibling::th
    // //table[@id='myTable']/tbody[1]/tr[1]/td[4]/select[1]
    private final By SelectOperation = By.xpath("//table[@id='myTable']/tbody[1]/tr[1]/td[4]/select[2]");
// //input[contains(@class,'btn btn-primary')]
   private final By ClickSave = By.xpath("//input[contains(@class,'btn btn-primary')]");
   // /html/body/div[3]/div[6]/div/section/form/div/div[2]/div/div/div[4]/div/table/tbody/tr/td[1]
   private final By Product = By.xpath("/html/body/div[3]/div[6]/div/section/form/div/div[2]/div/div/div[4]/div/table/tbody/tr/td[1]");

    private static WebElement element=null;

    public QtyAdjustmentScreen(WebDriver driver ) {
        super(driver);
    }
    public static WebElement selectWareHouse(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.id("warehouse_id"));
        Select skills = new Select(element);
//        int dropdown_value= driver.findElements(By.cssSelector("#warehouse_id > option")).size();
//        // #warehouse_id > option:nth-child(2)
//        System.out.println(dropdown_value);
//        Random random3=new Random();
//        int index= random3.nextInt(dropdown_value);
        skills.selectByValue("1");

        Thread.sleep(5000);
        return element;
    }
    public static WebElement selectOperation(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.name("action[]"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#myTable > tbody > tr > td.action > select > option")).size();
        System.out.println(dropdown_value);
        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);
        skills.selectByValue("1");
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }
    // warehouse_id
    @Step("open QtyAdjustment ")
    public HomeScreen addQty_adjustment() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        Faker fakeData=new Faker();
        new WebDriverWait(driver,Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(AddQtyAdjustment));
        driver.findElement(AddQtyAdjustment).click();

//        Thread.sleep(2000);

//        Thread.sleep(1000);
        new WebDriverWait(driver,Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated((By) selectWareHouse(driver)));
        selectWareHouse(driver);
        driver.findElement(SelectProduct).sendKeys(""+Barcode);
//        Thread.sleep(1000);
//        new WebDriverWait(driver,Duration.ofSeconds(5))
//            .until(ExpectedConditions.visibilityOfElementLocated(EditQty));

//        driver.findElement(ChangQuantity).sendKeys(Keys.BACK_SPACE);
//        driver.findElement(ChangQuantity).sendKeys(""+50);
          selectOperation(driver);
        new WebDriverWait(driver,Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated((By) selectOperation(driver)));
//        Thread.sleep(1000);

        driver.findElement(ClickSave).click();
        return new HomeScreen(driver);
    }
}
