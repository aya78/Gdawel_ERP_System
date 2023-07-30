package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EndToEndTesting  {
    public  WebDriver driver;
    //    private SHAFT.GUI.WebDriver new_driver;
    @Epic("SHAFT Web GUI Template")
    @Story("Google Basic Validations")
    @TmsLink("TC-001")
    @Description("Given I am on the Home page,\nThen the browser title should be 'Google'.")
    @Test(description = "Check that Home Page Title is correct.")
    public void Step1_login() throws InterruptedException {

        Hooks.open_browser("https://gdawel.app/");
    }

}
