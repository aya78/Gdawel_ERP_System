package com.sauceLabs.screens;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen  extends HomeScreen{
    private final By UserNameField = By.xpath("/html/body/div/div/div/div/div/div[2]/div/form/div[2]/div[1]/input");
//    private final By UserNameField = By.name("email");

    private final By PasswordField = By.xpath("//*[@id=\"password\"]");
    /************************************************************************************************************************************/
    private final By LoginButton = By.xpath("//*[@id=\"kt_body\"]/div[1]/div/div/div/div/div[2]/div/form/button");
    // btn btn-solid-main w-100 py-3 mt-5 border round
//    private final By LoginButton = By.className("btn btn-solid-main w-100 py-3 mt-5 border round");

    public String username = "ayak77431@gmail.com";
    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Step("login Using Valid Email And Password ==> user Name: [{username}], password: [{password}]")
    public HomeScreen loginUsingValidEmailAndPassword(){

        //driver.findElement(UserNameField).clear();


        driver.findElement(UserNameField).sendKeys(username);
        //driver.findElement(PasswordField).clear();
        driver.findElement(PasswordField).sendKeys(password);
        driver.findElement(LoginButton).click();

        return new HomeScreen(driver);
    }
}

//        extentReports = new ExtentReports("/home/hash-pc-8/Documents/vs_code/gdawel_test/ExtentReports/TestReports.html",true);
//                test =extentReports.startTest("verify login");
//                test.log(LogStatus.INFO,"username  can be selected and  valid ");
//
//                driver.findElement(UserNameField).sendKeys(username);
//                //driver.findElement(PasswordField).clear();
//                test.log(LogStatus.INFO,"password can be selected and  valid ");
//                driver.findElement(PasswordField).sendKeys(password);
//                test.log(LogStatus.INFO,"Login button can be clicked");
//                driver.findElement(LoginButton).click();
//                extentReports.endTest(test);
//                extentReports.flush();
