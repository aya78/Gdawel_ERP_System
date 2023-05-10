package Tests;

//import JsonFileManager;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.sauceLabs.screens.HomeScreen;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Gdawel App")
@Feature("Functional")
public class FunctionalTesting {
    private WebDriver driver;
//    public final JsonFileManager loginTestData = new JsonFileManager("src/main/resources/TestData/loginTestData.json");
    @BeforeSuite
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hash-pc-8/IdeaProjects/Gadawl/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("w3c", true);
        options.addArguments("--remote-allow-origins=*");
         driver = new ChromeDriver(options);
         driver.get("https://gdawel.app/");
         driver.manage().window().maximize();
        //driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

    }

    @Description
            (
                    "Given user open Gdawel website "+
                            "When click on Menu"+
                            "And click on Login"+
                            "And login Using Valid Email & Password"+
                            "And open customers page"+
                            "And click on counter Plus Button"+
                            "And click on save button"+
                            "And click on customer name "+
                            "And click on suppliers page"+
                            "And click on add supplier Button"+
                            "And click on save button"+
                            "And click on customer name"+
                            "And open customer group page"+
                            "And click on counter Plus Button"+
                            "And click on save button"+
                            "Then user should return to Home screen"
            )
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check Functionality of gdawel")
    @Test(description = "Check Functionality Scenario")
    public void TestScenario() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.invisibilityOfAllElements());
            new HomeScreen(driver)
                    .clickOnLogin()
                    .loginUsingValidEmailAndPassword()
//                    .clickOnSideMenu()
//                    .addAndViewCustomersPage()
//                    .navigateToSupplierList()
//                    .openSupplierPage()
//                    .navigateToCustomerGroup()
//                    .openCustomerGroup()
                    .navigateToProducts()
                    .addAndViewProductPage()
                    .navigateToProductsCategory()
                    .addProductCategory()
                  .navigateToQtyAdjustment()
                   .addQty_adjustment()
                    .navigateToStockCount()
                    .addStockCount()
                    .navigateToTransfer()
                    .addAndViewTransfers()
                    .navigateToWareHouses()
                    .addAndViewWareHouses()
                    .navigateToBrands()
                    .addBrand()
                    .navigateToUnits()
                    .addUnit()
                    .navigateToPurchases()
                    .addPurchaseInvoice()
                    .navigateToPurchases()
                    .addReturnPurchaseInvoice()
                    .navigateToQuotations()
                    .addSaleQuotationInvoice()
                    .navigateToQuotations()
                    .addPurchaseQuotationInvoice()
                    .navigateToGiftCards()
                    .addGiftCard()
                    .navigateToCoupons()
                    .addCoupon()
                    .navigateToSales()
                    .addSaleInvoice()
                    .navigateToSales()
                    .addReturnSaleInvoice()
                    .navigateToSales()
                    .AddNewDelivery()
                    .navigateToExchange()
                    .ViewExchange()
                    .navigateToReceipts()
                    .ViewReceipt()
                    ;
    }


//      @AfterSuite
//    public void TearDown() {
//        driver.quit();
//    }
}
