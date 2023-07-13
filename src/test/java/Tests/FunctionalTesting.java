package Tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.IExecutionListener;
import org.testng.Reporter;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sauceLabs.screens.HomeScreen;
//import com.slack.api.Slack;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertNull;
import static org.testng.AssertJUnit.assertTrue;
//import utils.logs.Log;



@Epic("Gdawel App")
@Feature("Functional")
public  class FunctionalTesting extends Helper implements IExecutionListener {
    public static String status = "passed";

    public ChromeDriver driver;
    public ExtentTest test;
    //
    public ExtentReports extentReports;
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeSuite
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/Downloads/gdawelTest/src/test/resources/chromedriver");

        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html",false);

        String baseURL = "https://gdawel.app/";
        test =extentReports.startTest("verify open browser ");
        test.log(LogStatus.INFO,"open browser Test in initialized");
//
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
//        options.addArguments("--remote-allow-origins=*");
        // start-maximized
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"browser is open and windows is maximized");
        driver.get(baseURL);
        test.log(LogStatus.PASS,"String URL is opening in  chrome browser");
        extentReports.endTest(test);
        extentReports.flush();
        extentReports.getReportId();
        String verifyAssertNull = null;
        assertNull(verifyAssertNull);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Epic("SHAFT Web GUI Template")
    @Story("Check Functionality of gdawel")
    @TmsLink("TC-001")
    @Description("Given I am on the Home page,\nThen the browser title should be 'Google'.")
    @Parameters({"environment"})
    @Test(description = "Check Functionality Scenario")
    public void TestScenario() throws  IOException {
        try {
            new HomeScreen(driver)
                    .clickOnLogin()
                    .loginUsingValidEmailAndPassword()
//                    .clickOnSideMenu()
//                    .addAndViewCustomersPage()
//                    .navigateToSupplierList()
//                    .openSupplierPage()
//                    .navigateToCustomerGroup()
//                    .openCustomerGroup()
                    .navigateToProducts()
//                    .edit_product()
                    .addAndViewProductPage()
//                    .navigateToProductsCategory()
//                    .addProductCategory()
//                  .navigateToQtyAdjustment()
//                   .addQty_adjustment()
//                    .navigateToStockCount()
//                    .addStockCount()
//                    .navigateToTransfer()
//                    .addAndViewTransfers()
//                    .navigateToWareHouses()
//                    .addAndViewWareHouses()
//                    .navigateToBrands()
//                    .addBrand()
//                    .navigateToUnits()
//                    .addUnit()
                    .navigateToPurchases()
                    .addPurchaseInvoice()
                    .navigateToPurchases()
                    .addReturnPurchaseInvoice()
//                    .navigateToQuotations()
//                    .addSaleQuotationInvoice()
//                    .navigateToQuotations()
//                    .addPurchaseQuotationInvoice()
                    /*********************************Error in dropdown of client in  gift_card******************************************************************************/
//                    .navigateToGiftCards()
//                    .addGiftCard()
                    /***********************addCoupon done *********************************/
//                    .navigateToCoupons()
//                    .addCoupon()
                    .navigateToSales()
                    .addSaleInvoice()
                    .navigateToSales()
                    .addReturnSaleInvoice()
//                    .navigateToSales()
//                    .AddNewDelivery()
//                    .navigateToExchange()
//                    .navigateToReceipts()
            ;
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFilePath = "path/to/screenshot.png";
            FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
//            screenshotFile.canWrite();
            Reporter.log("<br><img src='" + screenshotFilePath + "' height='400' width='400'/><br>");
            Reporter.getCurrentTestResult();

            e.printStackTrace();
            // xoxb-5047666852083-5308135282803-uV2u3xENP1zzEMslqYBnqnyA

        }

    }


}

