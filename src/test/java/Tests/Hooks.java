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
    @Before
    public static void open_browser(String URL ) throws InterruptedException {

//        WebDriverManager.chromedriver().setup();
//        URL="https://gdawel.app/";
        // /home/hash-pc-8/IdeaProjects/geckodriver-v0.33.0-win-aarch64/geckodriver.exe
        System.setProperty("webdriver.gecko.driver", "/home/hash-pc-8/IdeaProjects/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

//    @After
//    public void quit_browser(){
//        driver.quit();
//    }
}
