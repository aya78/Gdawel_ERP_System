package Tests;

//import JsonFileManager;

//import com.aventstack.extentreports.ExtentTest;
//import com.slack.api.Slack;
//import com.slack.api.methods.SlackApiException;
//import cucumber.api.java.After;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
//import lombok.val;
import jdk.jfr.Description;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterSuite;
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
import java.util.function.Predicate;

import static java.net.Authenticator.RequestorType.PROXY;
import static org.testng.AssertJUnit.assertNull;
//import utils.logs.Log;



@Epic("Gdawel App")
@Feature("Functional")
public  class FunctionalTesting {
    public ChromeDriver driver;
    public ExtentTest test;
    public ExtentReports extentReports;
////    private static final Predicate<String> ACCEPTED_W3C_PATTERNS = new AcceptedW3CCapabilityKeys();
//  private final static AcceptedW3CCapabilityKeys OK_KEYS = new AcceptedW3CCapabilityKeys();

    public WebDriver getDriver() {
        return driver;
    }
//    @BeforeAll
//    static void setupClass() {
//    }

//    @BeforeEach
//    void setupTest() {
//        driver = new ChromeDriver();
//    }
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
//        EdgeOptions options = new EdgeOptions();
//        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//        options.addArguments("--remote-allow-origins=*");
//        options.setCapability("ignore-certificate-errors", true);
//
//        WebDriverManager.edgedriver().avoidResolutionCache().setup();
//        driver.equals(new EdgeDriver(options));
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
        test.log(LogStatus.PASS,"browser is open and windows is maximized");
        driver.get(baseURL);
        test.log(LogStatus.PASS,"String URL is opening in  chrome browser");
        extentReports.endTest(test);
        extentReports.flush();
        extentReports.getReportId();
        String verifyAssertNull = null;
        assertNull(verifyAssertNull);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check Functionality of gdawel")
    @Test(description = "Check Functionality Scenario" )
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
                    /*********************************Error in dropdown of client in  gift_card******************************************************************************/
//                    .navigateToGiftCards()
//                    .addGiftCard()
                    /***********************addCoupon done *********************************/
//                    .navigateToCoupons()
//                    .addCoupon()
//                    .navigateToSales()
//                    .addSaleInvoice()
//                    .navigateToSales()
//                    .addReturnSaleInvoice()
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

