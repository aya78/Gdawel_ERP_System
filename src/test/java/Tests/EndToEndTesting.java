package Tests;

import com.ibm.icu.util.LocalePriorityList;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.annotation.Priority;

public class EndToEndTesting  {
    public ChromeDriver driver;    //    private SHAFT.GUI.WebDriver new_driver;
    @Epic("SHAFT Web GUI Template")
    @Story("Google Basic Validations")
    @TmsLink("TC-001")
    @Description("Given I am on the Home page,\nThen the browser title should be 'Google'.")
    @Test(description = "Check that Home Page Title is correct.")
    public void Step1_login() throws InterruptedException {

        Hooks.open_browser("https://gdawel.app/");
    }

}
