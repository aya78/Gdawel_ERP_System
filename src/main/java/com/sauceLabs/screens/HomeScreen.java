package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class HomeScreen {
//     public static By products = By.xpath("//*[@text='Products']");
public final WebDriver driver;

    public static By loginButton = By.cssSelector("#navbarSupportedContent > div > a.btn.btn-solid-main.login.form-btn.py-2.px-3.rounded.w-100.text-nowrap");
//    private final By openCustomerAndSupplierMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[2]/a");
//    // //*[@id="customer-menu"]
//    private final By customers = By.xpath("//*[@id=\"customer-menu\"]");
//    // //*[@id="customersupplier"]/li[2]/a
//    private final By suppliers = By.xpath("//*[@id=\"customersupplier\"]/li[2]/a");
//    // //*[@id="side-main-menu"]/li[3]/a
//    private final By openProductsAndWarehouseMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[3]/a");
//    //  //*[@id="transfer-list-menu"]/a
//    private final By openTransfers = By.xpath("//*[@id=\"transfer-list-menu\"]/aL");


//    public  WebDriver driver;
    public HomeScreen(WebDriver driver) {
        this.driver=driver;
    }
//    @Step("click On Side Menu")
//    public HomeScreen clickOnSideMenu(){
//        driver.findElement(openCustomerAndSupplierMenu).click();
//        return this;
//    }
    @Step("click On Login")
    public LoginScreen clickOnLogin() {
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }



}
