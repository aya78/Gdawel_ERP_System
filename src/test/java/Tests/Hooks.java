package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
//    @Before
//    public static void open_browser(String URL ) throws InterruptedException {
//
//        WebDriverManager.chromedriver().setup();
////        URL="https://gdawel.app/";
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        Thread.sleep(3000);
//    }
//
//    @After
//    public void quit_browser(){
//        driver.quit();
//    }
}
