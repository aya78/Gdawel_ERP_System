package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomeScreen {
//     public static By products = By.xpath("//*[@text='Products']");
public final WebDriver driver;

    public static By loginButton = By.cssSelector("#navbarSupportedContent > div > a.btn.btn-solid-main.login.form-btn.py-2.px-3.rounded.w-100.text-nowrap");
    private final By openCustomerAndSupplierMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[2]/a");
    private final By customers = By.id("customer-menu");
    private final By suppliers = By.xpath("//*[@id=\"customersupplier\"]/li[2]/a");
    private final By customerGroup = By.xpath("/html/body/nav/ul/li[2]/ul/li[3]/a");


    //    public  WebDriver driver;
    public HomeScreen(WebDriver driver) {
        this.driver=driver;
    }
    @Step("click On Login")
    public LoginScreen clickOnLogin() {
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }
    @Step("click On Side Menu Then open Customers")
    public CustomersScreen clickOnSideMenu(){
        driver.findElement(openCustomerAndSupplierMenu).click();
        driver.findElement(customers).click();

        return new CustomersScreen(driver);
    }
    @Step("click On Side Menu Then open Suppliers")
    public SuppliersScreen openSupplierList(){
        driver.findElement(suppliers).click();
        return new SuppliersScreen(driver);
    }
    @Step("click On Side Menu Then open Customer Group")
    public CustomerGroupScreen openCustomer_group(){
        driver.findElement(customerGroup).click();
        return new CustomerGroupScreen(driver);
    }


}
