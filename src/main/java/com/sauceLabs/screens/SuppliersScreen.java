package com.sauceLabs.screens;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class SuppliersScreen  extends HomeScreen{
    public  String random = RandomStringUtils.random(6, true, true);
    private String name;
    private String email;
    private String phone;
    public String vat_number;
    public String CRN_NUMBER ;

    //       private final By customers = By.xpath("//*[@id=\"customer-menu\"]");
    private final By AddSupplier = By.xpath("//a[@href='https://gdawel.app/dashboard/supplier/create']");
    private final By supplierName = By.cssSelector("#content > div > section > form > div > div.card > div > div:nth-child(1) > div:nth-child(2) > div > input");
    private final By supplierPhone = By.xpath("//input[@type='number']");
    private final By supplierEmail = By.xpath("//input[@placeholder='example@gdawel.app']");
    private final By vatNumber = By.xpath("//label[text()='الرقم الضريبي']/following::input");
    private final By CRN = By.xpath("//label[text()='رقم السجل التجاري']/following::input");
    private final By ClickSaveSupplier = By.xpath("//input[@type='submit']");
    private final By ViewSupplier = By.xpath("//a[@class='text-dark']");

    //    private static WebElement element=null;
    // public int randomInt;
//    static WebDriver driver = null;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /***************************************/
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getVat_number() {
        return vat_number;
    }
    public void setVat_number(String vatNumber) {
        this.vat_number = vat_number;
    }
    public String getCRN_NUMBER() {
        return CRN_NUMBER;
    }
    public void setCRN_NUMBER(String CRN_NUMBER) {
        this.CRN_NUMBER = CRN_NUMBER;
    }

    public SuppliersScreen(WebDriver driver) {
        super(driver);
    }
    @Step("open customer page than add new client and view exist client")
    public HomeScreen openSupplierPage() throws InterruptedException {
        Faker fakeData=new Faker();
        driver.findElement(AddSupplier).click();
        driver.findElement(supplierName).sendKeys(fakeData.name().fullName());
        driver.findElement(supplierPhone).sendKeys(fakeData.number().digits(11));
        driver.findElement(supplierEmail).sendKeys(""+random+"@gmail.com");
//        driver.findElement(vatNumber).sendKeys(fakeData.number().toString());
//        driver.findElement(CRN).sendKeys(fakeData.random().hex(20));
        driver.findElement(ClickSaveSupplier).click();
        driver.get("https://gdawel.app/dashboard/supplier/1");
//        driver.findElement(ViewSupplier).click();
        return new HomeScreen(driver);
    }
}
