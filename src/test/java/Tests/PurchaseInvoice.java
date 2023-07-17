package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.sauceLabs.screens.HomeScreen;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.testng.AssertJUnit.assertNull;

public class PurchaseInvoice {
    public static String status = "passed";

    public ChromeDriver driver;
    public ExtentTest test;
    String baseURL = "https://gdawel.app/";
     public HTMLReporter htmlReporter;
     public ExtentTest extentTest;
    public ExtentReports extentReports;
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeClass
    public void SetUp() {
        htmlReporter = new HTMLReporter("/home/hash-pc-8/Documents/vs_code/gdawel_test/NEWReports/my_extented_reports");

        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/Downloads/gdawelTest/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.get(baseURL);

    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check Functionality of purchase invoice")
    @TmsLink("TC-001")
    @Description("Given I am on the Home page,\nThen navigate to purchase and create new purchase invoice.")
    @Test(description = "Check Functionality Scenario")
    public void TestScenario() throws IOException {
        try {
            new HomeScreen(driver)
                    .clickOnLogin()
                    .loginUsingValidEmailAndPassword()
                    .navigateToPurchases()
                    .addPurchaseInvoice()

            ;
        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFilePath = "path/to/screenshot.png";
            FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
//            screenshotFile.canWrite();
            Reporter.log("<br><img src='" + screenshotFilePath + "' height='400' width='400'/><br>");
            Reporter.getCurrentTestResult();
            e.printStackTrace();


        }

    }
    @AfterClass
    public void after_class(){
        driver.quit();
        extentReports.flush();
    }
}
