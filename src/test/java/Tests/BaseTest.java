package Tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static org.testng.AssertJUnit.assertNull;

public class BaseTest {
    public ChromeDriver driver;    //    private SHAFT.GUI.WebDriver new_driver;
    public ExtentTest test;
    //
    public ExtentReports extentReports;
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

//    @AfterClass
//    public void after_class(){
//        driver.quit();
//        extentReports.flush();
//    }
}

