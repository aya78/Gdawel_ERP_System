package com.sauceLabs.screens;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomeScreen {
//     public static By products = By.xpath("//*[@text='Products']");
public final WebDriver driver;

    public static By loginButton = By.cssSelector("#navbarSupportedContent > div > a.btn.btn-solid-main.login.form-btn.py-2.px-3.rounded.w-100.text-nowrap");
    private final By openCustomerAndSupplierMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[2]/a");
    private final By customers = By.id("customer-menu");
    private final By suppliers = By.xpath("//*[@id=\"customersupplier\"]/li[2]/a");
    private final By customerGroup = By.xpath("/html/body/nav/ul/li[2]/ul/li[3]/a");
    private final By productsAndWarehouseMenu = By.xpath("//*[@id=\"side-main-menu\"]/li[3]/a");
    private final By products = By.xpath("//a[@href='https://gdawel.app/dashboard/products']");
    private final By product_category = By.xpath("//a[@href='https://gdawel.app/dashboard/category']");
    private final By AddQtyAdjustment = By.cssSelector("li#adjustment-list-menu>a");
    private final By OpenStockCount = By.cssSelector("li#stock-count-menu>a");

// li#transfer-list-menu>a
    private final By OpenTransfer = By.cssSelector("li#transfer-list-menu>a");
    // //td[@class='sorting_1']//a[1]
    private final By OpenWareHouse = By.cssSelector("li#warehouse-menu>a");

    private final By OpenBrands = By.cssSelector("li#brand-menu>a");
    private final By OpenUnits = By.cssSelector("li#unit-menu>a");
    private final By OpenPurchasesAndSales = By.cssSelector("ul#side-main-menu>li:nth-of-type(4)>a");
    private final By OpenQuotation = By.cssSelector("li#quotation-list-menu>a");
    private final By OpenGiftCards = By.cssSelector("li#gift-card-menu>a");
    private final By OpenCoupons = By.cssSelector("li#coupon-menu>a");



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
        driver.findElement(product_category).click();
        return new ProductCategoryScreen(driver);
    }
    @Step("click On Side Menu Then open QtyAdjustment")
    public QtyAdjustmentScreen navigateToQtyAdjustment(){
        driver.findElement(AddQtyAdjustment).click();
        return new QtyAdjustmentScreen(driver);
    }
    @Step("click On Side Menu Then open StockCount")
    public StockCountScreen navigateToStockCount(){
        driver.findElement(productsAndWarehouseMenu).click();

        driver.findElement(OpenStockCount).click();
        return new StockCountScreen(driver);
    }
    @Step("click On Side Menu Then open Transfer")
    public TransfersScreen navigateToTransfer(){

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
        return new PurchasesScreen(driver);
    }
    // QuotationScreen
    @Step("click On Side Menu Then open Quotation")
    public QuotationScreen navigateToQuotations(){
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
        driver.findElement(OpenCoupons).click();
        return new CouponScreen(driver);
    }




}
