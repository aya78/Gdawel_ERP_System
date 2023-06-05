package com.sauceLabs.screens;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomeScreen {
//     public static By products = By.xpath("//*[@text='Products']");
public final WebDriver driver;
    public ExtentTest test;
    public ExtentReports extentReports;
    public String password ="74108520";
    /*********************************************************  Done ***********************************************************************/
// https://gdawel.app/login
//    public static By loginButton = By.cssSelector("#navbarSupportedContent > div > a.btn.btn-solid-main.login.form-btn.py-2.px-3.rounded.w-100.text-nowrap");
    public static By loginButton = By.xpath("//a[@href='https://gdawel.app/login']");

    private final By openCustomerAndSupplierMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[2]/a");
    private final By customers = By.id("customer-menu");
    private final By suppliers = By.xpath("(//ul[@id='customersupplier']//a)[2]");
    /*****************************************************  Done ***************************************************************************/
// https://gdawel.app/dashboard/customer_group
//    private final By customerGroup = By.xpath("/html/body/nav/ul/li[2]/ul/li[3]/a");
    private final By customerGroup = By.xpath("//a[@href='https://gdawel.app/dashboard/customer_group']");
    /********************************************************************************************************************************/

    private final By productsAndWarehouseMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[3]/a");
//    private final By products = By.xpath("//a[@href='https://gdawel.app/dashboard/products']");
     private final By products = By.id("product-list-menu");

    private final By product_category = By.id("category-menu");
//    private final By AddQtyAdjustment = By.cssSelector("li#adjustment-list-menu>a");
        private final By AddQtyAdjustment = By.id("adjustment-list-menu");

    private final By OpenStockCount = By.id("stock-count-menu");

// li#transfer-list-menu>a
    private final By OpenTransfer = By.id("transfer-list-menu");
    // //td[@class='sorting_1']//a[1]
    private final By OpenWareHouse = By.id("warehouse-menu");

    private final By OpenBrands = By.cssSelector("li#brand-menu>a");
    private final By OpenUnits = By.cssSelector("li#unit-menu>a");
    private final By OpenPurchasesAndSales = By.cssSelector("ul#side-main-menu>li:nth-of-type(4)>a");
    private final By OpenQuotation = By.cssSelector("li#quotation-list-menu>a");
    private final By OpenGiftCards = By.cssSelector("li#gift-card-menu>a");
    private final By OpenCoupons = By.xpath("//li[@id='coupon-menu']//a[1]");

    private final By OpenPurchases = By.cssSelector("li#purchase-list-menu>a");
    private final By OpenSales = By.cssSelector("li#sale-list-menu>a");
    private final By OpenExchange = By.cssSelector("li#exchange-bonds-menu>a");
    private final By OpenReceipt = By.cssSelector("li#receipt-bonds-menu>a");
    private final By ClickOnProfileImg = By.xpath("//img[@class='shadow-sm']/following-sibling::span[1]");
    /********************************************************************************************************************************/
    private final By clickOnProfile = By.xpath("//span[text()[normalize-space()='الملف الشخصي']]");

    //    public  WebDriver driver;
    public HomeScreen(WebDriver driver) {
        this.driver=driver;
    }
    @Step("click On Login")
    public LoginScreen clickOnLogin() {
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }
    @Step("click On Side Menu Then open Customers")
    public CustomersScreen clickOnSideMenu(){
        driver.findElement(openCustomerAndSupplierMenu).click();
         boolean n =driver.findElement(customers).isSelected();
        if(n){
            System.out.println("Element is Present");
        }else{
            System.out.println("Element is Absent");
        }
        driver.findElement(customers).click();

        return new CustomersScreen(driver);
    }
    @Step("click On Side Menu Then open Suppliers")
    public SuppliersScreen navigateToSupplierList(){
        driver.findElement(suppliers).click();
        return new SuppliersScreen(driver);
    }
    @Step("click On Side Menu Then open Customer Group")
    public CustomerGroupScreen navigateToCustomerGroup(){
        driver.findElement(customerGroup).click();
        return new CustomerGroupScreen(driver);
    }
    @Step("click On Side Menu Then open product Group")
    public ProductsScreen navigateToProducts(){
        driver.findElement(productsAndWarehouseMenu).click();
        driver.findElement(products).click();
        return new ProductsScreen(driver);
    }
    @Step("click On Side Menu Then open product Group")
    public ProductCategoryScreen navigateToProductsCategory(){
//        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(product_category).click();
        return new ProductCategoryScreen(driver);
    }
    @Step("click On Side Menu Then open QtyAdjustment")
    public QtyAdjustmentScreen navigateToQtyAdjustment(){
//        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(AddQtyAdjustment).click();
        return new QtyAdjustmentScreen(driver);
    }
    @Step("click On Side Menu Then open StockCount")
    public StockCountScreen navigateToStockCount(){
//        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(OpenStockCount).click();
        return new StockCountScreen(driver);
    }
    @Step("click On Side Menu Then open Transfer")
    public TransfersScreen navigateToTransfer(){
        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(OpenTransfer).click();
        return new TransfersScreen(driver);
    }
    @Step("click On Side Menu Then open WareHouses")
    public WarehousesScreen navigateToWareHouses(){
        driver.findElement(OpenWareHouse).click();
        return new WarehousesScreen(driver);
    }
    @Step("click On Side Menu Then open Brands")
    public BrandScreen navigateToBrands(){
        driver.findElement(OpenBrands).click();
        return new BrandScreen(driver);
    }
    @Step("click On Side Menu Then open Units")
    public UnitScreen navigateToUnits(){
        driver.findElement(OpenUnits).click();
        return new UnitScreen(driver);
    }
    @Step("click On Side Menu Then open Purchases")
    public PurchasesScreen navigateToPurchases(){
       driver.findElement(OpenPurchasesAndSales).click();
       driver.findElement(OpenPurchases).click();
        return new PurchasesScreen(driver);
    }
    // QuotationScreen
    @Step("click On Side Menu Then open Quotation")
    public QuotationScreen navigateToQuotations(){
        driver.findElement(OpenPurchasesAndSales).click();

        driver.findElement(OpenQuotation).click();
        return new QuotationScreen(driver);
    }
    @Step("click On Side Menu Then open GiftCards")
    public GiftCardScreen navigateToGiftCards(){
        driver.findElement(OpenGiftCards).click();
        return new GiftCardScreen(driver);
    }
    @Step("click On Side Menu Then open Coupons")
    public CouponScreen navigateToCoupons(){
//        driver.findElement(OpenPurchasesAndSales).click();

        driver.findElement(OpenCoupons).click();
        return new CouponScreen(driver);
    }
    @Step("click On Side Menu Then open Sales")
    public SalesScreen navigateToSales(){
        driver.findElement(OpenPurchasesAndSales).click();
        driver.findElement(OpenSales).click();
        return new SalesScreen(driver);
    }
    @Step("click On Side Menu Then open Exchanges")
    public ExchangeScreen navigateToExchange(){
//        driver.findElement(OpenPurchasesAndSales).click();
        driver.findElement(OpenExchange).click();
        return new ExchangeScreen(driver);
    }
    @Step("click On Side Menu Then open Receipt")
    public ReceiptScreen navigateToReceipts(){
//        driver.findElement(OpenPurchasesAndSales).click();
        driver.findElement(OpenReceipt).click();
        return new ReceiptScreen(driver);
    }
    @Step("click On Side Menu Then open ProfileScreen")
    public ProfileScreen navigateToProfile(){
        driver.findElement(ClickOnProfileImg).click();
        driver.findElement(clickOnProfile).click();
        return new ProfileScreen(driver);
    }


}
