package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
//import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CouponScreen extends HomeScreen {
    public CouponScreen(WebDriver driver) {
        super(driver);
    }
    public  String random = RandomStringUtils.random(3, false, true);
    public  String num = RandomStringUtils.random(1, false, true);
    private final By AddCoupon = By.xpath("//button[text()[normalize-space()='أضف قسيمة جديدة']]");
    private final By GenerateCouponCode = By.xpath("//button[text()='إنشاء']");
    private final By CouponQty = By.xpath("(//input[@min='0'])[3]");
    private final By CouponValue = By.xpath("(//input[@min='0'])[2]");
    private final By SaveCoupon = By.cssSelector("div#create-modal>div>div>div:nth-of-type(2)>form>div:nth-of-type(2)>button");
    @Step(" add Coupon")
    public HomeScreen addCoupon() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(AddCoupon).click();
        driver.findElement(GenerateCouponCode).click();
        Thread.sleep(500);
        driver.findElement(CouponValue).sendKeys(""+random);
        driver.findElement(CouponQty).sendKeys(""+num);
        driver.findElement(SaveCoupon).click();
        return new HomeScreen(driver);
    }
}
