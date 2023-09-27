package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;

    public static void open_browser(String URL ) throws InterruptedException {
//       // URL="https://gdawel.app/";
//        // /home/hash-pc-8/IdeaProjects/geckodriver-v0.33.0-win-aarch64/geckodriver.exe
//
//        // "webdriver.gecko.driver", "/home/hash-pc-8/IdeaProjects/geckodriver-v0.33.0-win-aarch64/geckodriver.exe"
//        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/Downloads/gdawelTest/src/test/resources/Resources/chromedriver");
////        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
////        capabilities.setCapability("marionette", true);
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

//    @After
//    public void quit_browser(){
//        driver.quit();
//    }
}
