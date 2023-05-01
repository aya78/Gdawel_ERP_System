package Tests;

//import JsonFileManager;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.sauceLabs.screens.HomeScreen;

import java.util.concurrent.TimeUnit;

@Epic("Sauce labs Android App")
@Feature("End to End")
public class FunctionalTesting {
    private WebDriver driver;
//    public final JsonFileManager loginTestData = new JsonFileManager("src/main/resources/TestData/loginTestData.json");
    @BeforeSuite
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/IdeaProjects/Gadawl/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.addArguments("--remote-allow-origins=*");
         driver = new ChromeDriver(options);
         driver.get("https://gdawel.app/");
         driver.manage().window().maximize();
        //driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(400, TimeUnit.SECONDS);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Check Functionality of gdawel")
    @Test(description = "End To End Scenario")
    public void TestScenario() throws InterruptedException {

            new HomeScreen(driver)
                    .clickOnLogin()
                    .loginUsingValidEmailAndPassword()
                    .clickOnSideMenu()
                    .openCustomerPage()
                    .openSupplierList()
                    .openCustomer_group()
                    .openCustomerGroup();
    }

//    @AfterMethod
//    public void quitAndroidDriver() {
//        driver.quit();
//    }
}
