package com.sauceLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.sauceLabs.utils.JsonFileManager;
//import JsonFileManager;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import com.sauceLabs.screens.HomeScreen;

@Epic("Sauce labs Android App")
@Feature("End to End")
public class EndToEndTesting {
    private WebDriver driver;
    public final JsonFileManager loginTestData = new JsonFileManager("src/test/resources/loginTestData.json");
//    private final JsonFileManager checkoutTestData = new JsonFileManager("src/test/resources/testData/checkoutTestData.json");
//    private final JsonFileManager paymentTestData = new JsonFileManager("src/test/resources/testData/paymentTestData.json");

    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/IdeaProjects/Gadawl/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver=new ChromeDriver();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Buy A product")
    @Test(description = "End To End Scenario")
    public void endToEndScenario() {
        new HomeScreen(driver)
                .clickOnSideMenu()
                .clickOnLogin()
                .loginUsingValidEmailAndPassword
                        (
                                loginTestData.getTestData("email"),
                                loginTestData.getTestData("password")
                        );

    }

//    @AfterMethod
//    public void quitAndroidDriver() {
//        driver.quit();
//    }
}
