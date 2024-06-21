package Tests;

import com.sauceLabs.screens.HomeScreen;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class purchaseInvoice extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Check Functionality of purchase invoice")
    @TmsLink("TC-002")
    @Description("Given I am on the Home page,\nThen navigate to purchase and create new purchase invoice.")
    @Test(description = "Check Functional Scenario of purchase")
    public void TestScenarioFor__Purchases() throws IOException {
        try {
            new HomeScreen(driver)
                    .clickOnLogin()
                    .loginUsingValidEmailAndPassword()
                    .navigateToPurchases();
//                    .addPurchaseInvoice()
//
//            ;
//            new HomeScreen(driver)
//                    .clickOnLogin()
//                    .loginUsingValidEmailAndPassword()
//                    .navigateToPurchases()
//                    .addReturnPurchaseInvoice()
//
//            ;

        } catch (Exception e) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFilePath = "path/to/screenshot.png";
            FileUtils.copyFile(screenshotFile, new File(screenshotFilePath));
//            screenshotFile.canWrite();
            Reporter.log("<br><img src='" + screenshotFilePath + "' height='400' width='400'/><br>");
            Reporter.getCurrentTestResult();
            e.printStackTrace();


        }

    }

}
