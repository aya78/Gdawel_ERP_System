package com.sauceLabs.screens;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.sauceLabs.screens.HomeScreen;

public class CustomersScreen extends HomeScreen{
      public  String random = RandomStringUtils.random(6, true, true);
    private String name;
    private String email;
    private String phone;
    public String vat_number;
    public String CRN_NUMBER ;
     //private final By AddClient = By.xpath("(//a[@href='https://gdawel.app/dashboard/customer/create'])[2]");
        private final By clientName = By.cssSelector("#name");
        ////////// input
        private final By clientPhone = By.xpath("//label[text()='رقم الهاتف ']/following::input");
        private final By clientEmail = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[2]/div/div[1]/div[6]/div/input");
         private final By vatNumber = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[2]/div/div[1]/div[5]/div/input");
        private final By CRN = By.xpath("/html/body/div[2]/div[6]/div/section/form/div/div[2]/div/div[1]/div[5]/div/input");
        private final By ClickSaveClient = By.xpath("//input[@type='submit']");
        private final By ViewClient = By.xpath("//table[@id='customer-table']/tbody[1]/tr[1]/td[2]/a[1]");
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
    public HomeScreen addAndViewCustomersPage() throws InterruptedException {
//       extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html",false);
//        test =extentReports.startTest("verify Add client ");
        Faker fakeData=new Faker();
//        driver.findElement(AddClient).click();
        driver.get("https://gdawel.app/dashboard/customer/create");
        driver.findElement(clientName).sendKeys(fakeData.name().fullName());
//        if(driver.findElement(clientName).isDisplayed())
//        {
//            test.log(LogStatus.PASS,"clientName is entered");
//        }else
//            test.log(LogStatus.FAIL,"fail to find clientName element");

//      WebElement num = driver.findElement(clientPhone);
        /*************************************************************************************************************************************/
        driver.findElement(clientPhone).sendKeys(fakeData.number().digits(11));
//
//        if(driver.findElement(clientPhone).isDisplayed())
//        {
//            test.log(LogStatus.PASS,"clientPhone is entered");
//        }else
//            test.log(LogStatus.FAIL,"fail to find clientPhone element");
//        driver.findElement(clientEmail).sendKeys(""+random+"@gmail.com");
//        driver.findElement(vatNumber).sendKeys(fakeData.number().toString());
//        driver.findElement(CRN).sendKeys(fakeData.random().hex(20));
        /****************************************************************************************************/
        driver.findElement(ClickSaveClient).click();
//        if(driver.findElement(ClickSaveClient).isDisplayed())
//        {
//            test.log(LogStatus.PASS,"ClickSaveClient is displayed");
//        }else
//            test.log(LogStatus.FAIL,"fail to find ClickSaveClient button");
        driver.findElement(ClickSaveClient).click();
        extentReports.endTest(test);
        extentReports.flush();

            //driver.get("https://gdawel.app/dashboard/customer/1");
//        driver.findElement(ViewClient).click();
        return new HomeScreen(driver);
    }
}
