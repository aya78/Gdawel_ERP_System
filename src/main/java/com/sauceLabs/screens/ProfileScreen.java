package com.sauceLabs.screens;

import io.qameta.allure.Step;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileScreen extends HomeScreen{
//    private String password = "74108520";

    public ProfileScreen(WebDriver driver) {
        super(driver);
    }
    // /html/body/div[2]/div[6]/div/section/div/div/div[2]/div[1]/div[1]/a
    private final By clickOnEditProfile = By.xpath("/html/body/div[2]/div[6]/div/section/div/div/div[2]/div[1]/div[1]/a");
    // /html/body/div[2]/div[6]/div/form/section/div/div/div[2]/div/div[2]/div[4]/input
    private final By SaveEditProfile = By.xpath("//input[@type='submit']");
    private final By OpenEditPassword = By.xpath("//a[contains(@class,'nav-link fw-bold')]/following-sibling::a");
    private final By OldPassword = By.xpath("//input[@placeholder='كلمة المرور القديمة ']");
    private final By NewPassword = By.xpath("//input[@placeholder='كلمة المرور الجديدة']");
    private final By RepeatNewPassword = By.xpath("//input[@placeholder='تأكيد كلمة المرور الجديدة']");
    private final By SavePassword = By.xpath("//input[@value='حفظ']");
    // //a[@class='nav-link fw-bold']/following-sibling::a
    private final By OpenLogs = By.xpath("//a[@class='nav-link fw-bold']/following-sibling::a");
    // //a[@class='btn btn-outline-primary']
    private final By ViewLogs = By.xpath("//a[@class='btn btn-outline-primary']");
    // (//a[contains(@class,'nav-link fw-bold')]/following-sibling::a)[3]
    private final By OpenMyTransaction = By.xpath("(//a[contains(@class,'nav-link fw-bold')]/following-sibling::a)[3]");
    @Step("open profile settings")
    public HomeScreen openAndEditProfile(){
        driver.navigate().to("https://gdawel.app/dashboard/profile/edit");
        driver.findElement(SaveEditProfile).click();
        return  new HomeScreen(driver);
    }
//    @Step
//    public HomeScreen ChangePassword(){
//        Faker fakeData=new Faker();
//        driver.findElement(OpenEditPassword).click();
//        driver.findElement(OldPassword).sendKeys(""+password);
//        int p = Integer.parseInt(fakeData.number().digits(8));
//        driver.findElement(NewPassword).sendKeys(""+p);
//        driver.findElement(RepeatNewPassword).sendKeys(""+p);
//        System.out.println(p);
//        driver.findElement(SavePassword).click();
//        // 92098677
//        password= String.valueOf(p);
//        return  new HomeScreen(driver);
//    }

    @Step("open logs")
    public HomeScreen openLOGs(){
        driver.findElement(OpenLogs).click();
        driver.findElement(ViewLogs).click();
        return  new HomeScreen(driver);
    }
    @Step("open My Transaction")
    public HomeScreen OpenMyTransaction(){

        driver.findElement(OpenMyTransaction).click();
        return  new HomeScreen(driver);
    }

}
