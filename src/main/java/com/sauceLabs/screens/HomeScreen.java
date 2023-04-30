package screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeScreen {
//     public static By products = By.xpath("//*[@text='Products']");
    public static By loginButton = By.xpath("//*[@id=\"navbarSupportedContent\"]/div/a[1]");
    private final By openCustomerAndSupplierMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[2]/a");
    // //*[@id="customer-menu"]
    private final By customers = By.xpath("//*[@id=\"customer-menu\"]");
    // //*[@id="customersupplier"]/li[2]/a
    private final By suppliers = By.xpath("//*[@id=\"customersupplier\"]/li[2]/a");
    // //*[@id="side-main-menu"]/li[3]/a
    private final By openProductsAndWarehouseMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[3]/a");
    //  //*[@id="transfer-list-menu"]/a
    private final By openTransfers = By.xpath("//*[@id=\"transfer-list-menu\"]/aL");


    public static WebDriver driver;
    public HomeScreen(WebDriver driver) {
        this.driver=driver;
    }
    @Step("click On Side Menu")
    public HomeScreen clickOnSideMenu(){
        driver.findElement(openCustomerAndSupplierMenu).click();
        return this;
    }
    @Step("click On Login")
    public LoginScreen clickOnLogin() {
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }



}
