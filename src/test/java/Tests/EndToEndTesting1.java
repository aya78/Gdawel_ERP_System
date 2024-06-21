package Tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sauceLabs.screens.HomeScreen;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertNull;

public class EndToEndTesting1 {
    public ChromeDriver driver;    //    private SHAFT.GUI.WebDriver new_driver;
    public ExtentTest test;
    //
    public ExtentReports extentReports;
//    @Epic("SHAFT Web GUI Template")
//    @Story("Google Basic Validations")
//    @TmsLink("TC-001")
//    @Description("Given I am on the Home page,\nThen the browser title should be 'Google'.")
//    @Test(description = "Check that Home Page Title is correct.")
//    public void Step1_login() throws InterruptedException {
//
//        Hooks.open_browser("https://gdawel.app/");
//    }

    @BeforeSuite
    public void SetUp() {
        //System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/Downloads/gdawelTest/src/test/resources/Resources/chromedriver");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NANABODEY\\IdeaProjects\\Gdawel_ERP_System\\src\\test\\java\\untils\\chromedriver.exe");
        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html", false);

        String baseURL = "https://gdawel.app/";
        test = extentReports.startTest("verify open browser ");
        test.log(LogStatus.INFO, "open browser Test in initialized");
//
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
//        options.addArguments("--remote-allow-origins=*");
        // start-maximized
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        test.log(LogStatus.PASS, "browser is open and windows is maximized");
        driver.get(baseURL);
        test.log(LogStatus.PASS, "String URL is opening in  chrome browser");
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
    public void TestScenario() throws IOException {
        try {
            new HomeScreen(driver)
                    .clickOnLogin()
                    .loginUsingValidEmailAndPassword();
//        for(int i = 0 ;i <= 10 ; i++ ) {

            new HomeScreen(driver)
                    .navigateToProducts()
                    .addAndViewProductPage()
                    .navigateToPurchases()
                    .addPurchaseInvoice()
//                    .navigateToPurchases()
//                    .addReturnPurchaseInvoice()
//                    .navigateToQuotations()
//                    .addSaleQuotationInvoice()
//                    .navigateToQuotations()
//                    .addPurchaseQuotationInvoice()
//                    .navigateToSales()
//                    .addSaleInvoice()
//                    .navigateToSales()
//                    .addReturnSaleInvoice()

            ;

//        }
        }
 catch (Exception e) {
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
