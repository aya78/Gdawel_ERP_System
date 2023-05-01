package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerGroupScreen extends HomeScreen {
    private String name;
    private final By AddCustomerGroup = By.cssSelector("#createBtn");
    private final By GroupName = By.xpath("//label[text()='اسم تصنيف العميل']/following::input");
    // //input[@max='100']
    private final By GroupPercent = By.xpath("//input[@max='100']");
    // //input[@type='submit']
    private final By ClickSaveGroup = By.xpath("//input[@type='submit']");
    //    private static WebElement element=null;
    // public int randomInt;
//    static WebDriver driver = null;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CustomerGroupScreen(WebDriver driver) {
        super(driver);
    }
    @Step("open customerGroup page Then add new Customer Group")
    public HomeScreen openCustomerGroup() {
        Faker fakeData=new Faker();

        driver.findElement(AddCustomerGroup).click();
        driver.findElement(GroupName).sendKeys(fakeData.cat().registry());
        driver.findElement(GroupPercent).sendKeys(""+0);
        driver.findElement(ClickSaveGroup).click();

        return new HomeScreen(driver);
    }

}
