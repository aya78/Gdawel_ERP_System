package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerGroupScreen extends HomeScreen {
    private String name;
    private final By AddCustomerGroup = By.id("createBtn");
    private final By GroupName = By.xpath("//label[text()='اسم تصنيف العميل']/following::input");
    private final By GroupPercent = By.xpath("//input[@max='100']");
    private final By ClickSaveGroup = By.xpath("//input[@type='submit']");
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
    public HomeScreen openCustomerGroup() throws InterruptedException {
        Faker fakeData=new Faker();

        Thread.sleep(2000);
        driver.findElement(AddCustomerGroup).click();
        Thread.sleep(2000);

        driver.findElement(GroupName).sendKeys(fakeData.cat().registry());
        Thread.sleep(2000);

        driver.findElement(GroupPercent).sendKeys(""+0);
        Thread.sleep(2000);

        driver.findElement(ClickSaveGroup).click();

        return new HomeScreen(driver);
    }

}
