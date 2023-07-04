package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

//import static com.sauceLabs.screens.SalesScreen.element;

public class TransfersScreen  extends HomeScreen{

    int[] arr = {4155632,65333756,6922869,4026422};
    public TransfersScreen(WebDriver driver) {
        super(driver);
    }
    // https://gdawel.app/dashboard/transfers/create
    private final By AddTransfer = By.xpath("//a[@href='https://gdawel.app/dashboard/transfers/create']");
    // (//button[@title='اختر المخزن...'])[2]
//    private final By ClickFromWareHouse = By.id("from_warehouse_id");
//    // bs-select-6-0
//    private final By SelectWareHouse1 = By.cssSelector("a#bs-select-6-0");
//    private final By ClickToWareHouse = By.id("to_warehouse_id");
//    private final By SelectWareHouse2 = By.cssSelector("a#bs-select-8-1");
    private final By SelectProduct = By.id("productcodeSearch");
    // //div[@class='card-body py-0']//div
  //  private final By clickSpace = By.xpath("//div[@class='card-body py-0']//div");

    private final By SaveTransfer = By.id("submit-button");
    // //td[@class='sorting_1']//a[1]
    private final By ViewTransfer = By.xpath("//a[@href='https://gdawel.app/dashboard/transfers/691f0a7c-a0af-4d24-8f86-f7beaf8f1ac5']");
    private static WebElement element=null;

    public static WebElement selectWareHouse1(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.id("from_warehouse_id"));
        Select skills = new Select(element);

        skills.selectByValue("1");
        Thread.sleep(5000);
        return element;
    }
    public static WebElement selectWareHouse2(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.id("to_warehouse_id"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#to_warehouse_id > option")).size();
        // #to_warehouse_id > option:nth-child(4)
        System.out.println(dropdown_value);
        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);
        skills.selectByIndex(index);
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }
    // status
    public static WebElement selectStatus(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.name("status"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#transfer-form > div > div.card > div > div > div:nth-child(3) > div > div > select > option")).size();
        // #to_warehouse_id > option:nth-child(4)
        System.out.println(dropdown_value);
        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);
        skills.selectByIndex(index);
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }


    @Step("open add Transfers ")
    public HomeScreen addAndViewTransfers() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver,);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));


        driver.findElement(AddTransfer).click();
        Thread.sleep(2000);
        selectWareHouse1(driver);
        Thread.sleep(1000);

        selectWareHouse2(driver);
        Thread.sleep(1000);
        selectStatus(driver);
        Thread.sleep(1000);

        driver.findElement(SelectProduct).sendKeys("58554172");
        Thread.sleep(1000);

//        wait.until(ExpectedConditions.elementToBeClickable(SelectProduct));
//        driver.findElement(clickSpace).click();
        driver.findElement(SaveTransfer).click();
        driver.findElement(ViewTransfer).click();
        return new HomeScreen(driver);
    }
}
