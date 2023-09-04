package Tests;

import com.sauceLabs.screens.HomeScreen;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProfileTest {
    private WebDriver driver;
    @BeforeSuite
    public void SetUpp() {

        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/Downloads/gdawelTest/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://gdawel.app/");
        driver.manage().window().maximize();
        //driver=new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @Description
            (
                    "Given user open Gdawel website "+
                            "When click on Menu"+
                            "And click on Login"+
                            "And login Using Valid Email & Password"

            )
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check Functionality of gdawel")
    @Test(description = "Check Functionality Scenario for Profile")
    public void TestProfile() throws InterruptedException, IOException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        new HomeScreen(driver)
//                .clickOnLogin()
//                .loginUsingValidEmailAndPassword()
//                .navigateToProfile()
//                .openAndEditProfile()
////                .navigateToProfile()
////                .ChangePassword()
//                .navigateToProfile()
//                .openLOGs()
//                .navigateToProfile()
//                .OpenMyTransaction()
        ;
    }

}
