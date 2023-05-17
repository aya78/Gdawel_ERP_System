package Tests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.util.Base64;

public class ScreenshotListener extends TestListenerAdapter  {


//        @Override
//        public void onTestFailure(ITestResult result) {
//            Object testClass = result.getInstance();
//            WebDriver driver = ((FunctionalTesting) testClass).getDriver();
//
//            if (driver == null) {
//                // Take a screenshot of the current page
//                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//                // Embed the screenshot in the TestNG report
//                Reporter.log("<br><a href=\"#\" onclick=\"window.open('data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot) + "')\">" +
//                        "<img src=\"data:image/png;base64," + Base64.getEncoder().encodeToString(screenshot) + "\" width=\"400\"></a><br>");
//            }
//        }

}
