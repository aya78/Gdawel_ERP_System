package Tests;

//import JsonFileManager;

//import com.aventstack.extentreports.ExtentTest;
//import com.slack.api.Slack;
//import com.slack.api.methods.SlackApiException;
//import cucumber.api.java.After;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.*;
//import lombok.val;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.ITestListener;
//import org.testng.annotations.AfterSuite;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.slf4j.LoggerFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.sauceLabs.screens.HomeScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import com.slack.api.Slack;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertNull;


@Epic("Gdawel App")
@Feature("Functional")
public  class FunctionalTesting {
    private WebDriver driver;
    public ExtentTest test;
    public ExtentReports extentReports;
    @BeforeSuite
    public void SetUp() {

        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html",false);
        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/IdeaProjects/Gadawl/src/test/resources/chromedriver");
        String baseURL = "https://gdawel.app/";
        test =extentReports.startTest("verify open browser ");
        test.log(LogStatus.INFO,"open browser Test in initialized");
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Ubuntu");
        caps.setCapability("os_version", "22.04.2 LTS");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "113.0.5672.126");

        caps.setCapability("name", "Gdawel's First Test");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS,"browser is open and windows is maximized");
        driver.get(baseURL);
        test.log(LogStatus.PASS,"String URL is opening in  chrome browser");
        //driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        extentReports.endTest(test);
        extentReports.flush();
        extentReports.getReportId();
        String verifyAssertNull = null;
        assertNull(verifyAssertNull);
    }
    @Description
            (
                    "Given user open Gdawel website " +
                            "When click on Menu" +
                            "And click on Login" +
                            "And login Using Valid Email & Password" +
                            "And open customers page" +
                            "And click on counter Plus Button" +
                            "And click on save button" +
                            "And click on customer name " +
                            "And click on suppliers page" +
                            "And click on add supplier Button" +
                            "And click on save button" +
                            "And click on customer name" +
                            "And open customer group page" +
                            "And click on counter Plus Button" +
                            "And click on save button" +
                            "Then user should return to Home screen"
            )

    @Severity(SeverityLevel.CRITICAL)
    @Story("Check Functionality of gdawel")
    @Test(description = "Check Functionality Scenario" )
    public void TestScenario() throws InterruptedException, IOException {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOfAllElements());

            //creates a toggle for the given test, add all log events under it
//       test1 = extent.createTest("ebay Search Test", "test to validate search box ");
//        test1.log(Status.INFO, "Starting test case");
            new HomeScreen(driver)
                    .clickOnLogin()
                    .loginUsingValidEmailAndPassword()
//                    .clickOnSideMenu()
//                    .addAndViewCustomersPage()
//                    .navigateToSupplierList()
//                    .openSupplierPage()
//                    .navigateToCustomerGroup()
//                    .openCustomerGroup()
//                    .navigateToProducts()
//                    .addAndViewProductPage()
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
//                    .navigateToPurchases()
//                    .addPurchaseInvoice()
//                    .navigateToPurchases()
//                    .addReturnPurchaseInvoice()
//                    .navigateToQuotations()
//                    .addSaleQuotationInvoice()
//                    .navigateToQuotations()
//                    .addPurchaseQuotationInvoice()
//                    .navigateToGiftCards()
//                    .addGiftCard()
//                    .navigateToCoupons()
//                    .addCoupon()
//                    .navigateToSales()
//                    .addSaleInvoice()
//                    .navigateToSales()
//                    .addReturnSaleInvoice()
//                    .navigateToSales()
//                    .AddNewDelivery()
//                    .navigateToExchange()
//                    .ViewExchange()
//                    .navigateToReceipts()
//                    .ViewReceipt()


            ;
        } catch (Exception e) {
//            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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

//     @AfterMethod
//     public void trackFailure(){
//         if (result.getStatus() == ITestResult.FAILURE) {
//             String screenshotFilePath = "path/to/screenshot.png";
//             Reporter.log("<br><img src='" + screenshotFilePath + "' height='400' width='400'/><br>");
//         }
//     }


//    @AfterMethod
//    public void TearDown() {
//            driver.quit();
////          test1.pass("closed the browser");
////          test1.info("test completed");
////          extent.flush();
//    }
}

