package com.sauceLabs.screens;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersScreen extends HomeScreen{
      public  String random = RandomStringUtils.random(6, true, true);
    private String name;
    private String email;
    private String phone;
    public String vat_number;
    public String CRN_NUMBER ;

//       private final By customers = By.xpath("//*[@id=\"customer-menu\"]");
        private final By AddClient = By.xpath("(//a[@href='https://gdawel.app/dashboard/customer/create'])[2]");
        private final By clientName = By.cssSelector("#name");
        private final By clientPhone = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[2]/div/div[1]/div[5]/div/input");
        private final By clientEmail = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[2]/div/div[1]/div[6]/div/input");
         private final By vatNumber = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[2]/div/div[1]/div[5]/div/input");
        private final By CRN = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[2]/div/div[1]/div[5]/div/input");
        private final By ClickSaveClient = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[1]/div/div/div/input");
        private final By ViewClient = By.xpath("/html/body/div[2]/div[6]/div/section/div/div[2]/div/table/tbody/tr[1]/td[2]/a");

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
    public CustomersScreen(WebDriver driver) {
        super(driver);
    }
    @Step("open customer page than add new client and view exist client")
    public HomeScreen openCustomerPage() throws InterruptedException {
        Faker fakeData=new Faker();

//        driver.findElement(customers).click();

        driver.findElement(AddClient).click();
        driver.findElement(clientName).sendKeys(fakeData.name().fullName());
        driver.findElement(clientPhone).sendKeys(fakeData.number().digits(11));
        driver.findElement(clientEmail).sendKeys(""+random+"@gmail.com");
//        driver.findElement(vatNumber).sendKeys(fakeData.number().toString());
//        driver.findElement(CRN).sendKeys(fakeData.random().hex(20));
        driver.findElement(ClickSaveClient).click();
//        driver.wait(2000);
        driver.findElement(ViewClient).click();
        return new HomeScreen(driver);
    }
}
