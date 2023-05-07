package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransfersScreen  extends HomeScreen{
    int[] arr = {4155632,65333756,6922869,4026422};
    public TransfersScreen(WebDriver driver) {
        super(driver);
    }
    private final By AddTransfer = By.xpath("//div[@id='data-length-operations']//a[1]");
    // (//button[@title='اختر المخزن...'])[2]
    private final By ClickFromWareHouse = By.xpath("(//button[@title='اختر المخزن...'])[2]");
    private final By SelectWareHouse1 = By.cssSelector("a#bs-select-6-0");
    private final By ClickToWareHouse = By.xpath("//label[text()='الى مخزن *']/following-sibling::div");
    private final By SelectWareHouse2 = By.cssSelector("a#bs-select-8-1");
    private final By SelectProduct = By.xpath("//input[contains(@class,'form-control rounded-right')]");
    // //div[@class='card-body py-0']//div
    private final By clickSpace = By.xpath("//div[@class='card-body py-0']//div");

    private final By SaveTransfer = By.xpath("//input[@value='حفظ']");
    // //td[@class='sorting_1']//a[1]
    private final By ViewTransfer = By.xpath("//td[text()='2023-05-07 11:55:37']/following-sibling::td");

    @Step("open add Transfers ")
    public HomeScreen addAndViewTransfers() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));

        driver.findElement(AddTransfer).click();
        driver.findElement(ClickFromWareHouse).click();
        driver.findElement(SelectWareHouse1).click();
        driver.findElement(ClickToWareHouse).click();
        driver.findElement(SelectWareHouse2).click();
        driver.findElement(SelectProduct).sendKeys(""+2);
        wait.until(ExpectedConditions.elementToBeClickable(SelectProduct));
        driver.findElement(clickSpace).click();
        driver.findElement(SaveTransfer).click();
        driver.findElement(ViewTransfer).click();
        return new HomeScreen(driver);
    }
}
