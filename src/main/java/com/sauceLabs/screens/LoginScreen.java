package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen  extends HomeScreen{
    private final By UserNameField = By.cssSelector("#input-644e6e4557dca");

    private final By PasswordField = By.xpath("//*[@id=\"password\"]");
    private final By LoginButton = By.xpath("//*[@id=\"kt_body\"]/div[1]/div/div/div/div/div[2]/div/form/button");
    private String username = "moheyaya026@gmail.com";
    private String password = "123456789";
    public LoginScreen(WebDriver driver) {
        super(driver);
    }


    @Step("login Using Valid Email And Password ==> user Name: [{username}], password: [{password}]")
    public HomeScreen loginUsingValidEmailAndPassword(){
        driver.findElement(UserNameField).clear();
        driver.findElement(UserNameField).sendKeys(username);
        driver.findElement(PasswordField).clear();
        driver.findElement(PasswordField).sendKeys(password);
        driver.findElement(LoginButton).click();
        return new HomeScreen(driver);
    }
}
