package com.sauceLabs.screens;

//import com.aventstack.extentreports.TestListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
//import groovy.beans.ListenerList;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
//import org.apache.commons.io.FileUtils;
//import org.junit.jupiter.api.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.unitils.thirdparty.org.apache.commons.io.FileUtils;
//import com.sauceLabs.ActionDriver.Action;
//import com.Bayt.Base.Base;
//import untils.ListenerList.TestListener;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

//@ListenerList({TestListener.class})
@Epic("Functional Tests")
@Feature("Login Tests")

public class LoginScreen  extends HomeScreen{
    private final By UserNameField = By.xpath("/html/body/div/div/div/div/div/div[2]/div/form/div[2]/div[1]/input");
//    private final By UserNameField = By.name("email");

    private final By PasswordField = By.xpath("//*[@id=\"password\"]");
    /************************************************************************************************************************************/
    private final By LoginButton = By.xpath("//*[@id=\"kt_body\"]/div[1]/div/div/div/div/div[2]/div/form/button");
    // btn btn-solid-main w-100 py-3 mt-5 border round
//    private final By LoginButton = By.className("btn btn-solid-main w-100 py-3 mt-5 border round");

    public String username = "detebag627@elixirsd.com";
    // cabin73954@vikinoko.com
    // mawin14019@estudys.com
    // detebag627@elixirsd.com
    // horeg91128@meogl.com
    // gevosom897@meogl.com
//public String username = "gevosom897@meogl.com";
    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Step("login Using Valid Email And Password ==> user Name: [{username}], password: [{password}]")
    public HomeScreen loginUsingValidEmailAndPassword() throws IOException, InterruptedException {
        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html",false);
        test =extentReports.startTest("verify Login  ");
        test.log(LogStatus.PASS,"browser is open and windows is maximized");
        if(driver.findElement(UserNameField).isDisplayed())
        {
            test.log(LogStatus.PASS,"Username is entered");
        }else{
            test.log(LogStatus.FAIL,"fail to find username element");
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFilePath = "path/to/screen.png";
            FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
//            test.addScreenCapture("path/to/screen.png");
        }

        //driver.findElement(UserNameField).clear();
        driver.findElement(UserNameField).sendKeys(username);
        // driver.navigate().refresh();
//        driver.findElement(UserNameField).sendKeys(username);

        if(driver.findElement(PasswordField).isDisplayed())
        {
            test.log(LogStatus.PASS,"Password is entered");
        }else
            test.log(LogStatus.FAIL,"fail to find password element");
        //driver.findElement(PasswordField).clear();
        driver.findElement(PasswordField).sendKeys(password);


        if(driver.findElement(LoginButton).isDisplayed())
        {
            test.log(LogStatus.PASS,"gadawel app is open ");
        }else
            test.log(LogStatus.FAIL,"fail to find login button");

        driver.findElement(LoginButton).click();
//        test.addScreenCaptureFromPath("screenshot.png");

        extentReports.endTest(test);
        extentReports.flush();
//        Desktop.getDesktop().browse(new File("TestReports.html").toURI());
//        WebElement modal = driver.findElement(By.xpath(""));
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.visibilityOfElementLocated((By) modal));
        //Thread.sleep(1000);
        Actions action = new Actions(driver);
            action.moveByOffset(0, 0).click().build().perform();

        return new HomeScreen(driver);
    }
}

