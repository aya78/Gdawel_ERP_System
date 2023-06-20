package com.sauceLabs.screens;

//import cucumber.api.java.eo.Se;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class GiftCardScreen extends HomeScreen {
    public GiftCardScreen(WebDriver driver) {
        super(driver);
    }
    private final By AddGiftCard = By.xpath("//button[text()[normalize-space()='إضافة بطاقة هدايا']]");
    // GiftCard
    // //div[@id='gift_card-modal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/button[1]
    /***************************************************************************************************************************************************/

    private final By GenerateCardId = By.xpath("//div[@id='gift_card-modal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/button[1]");
//    private final By AddGiftValue = By.xpath("//input[@type='number']");
    // amount
    private final By AddGiftValue = By.name("amount");

    //    private final By ClickClients = By.xpath("(//select[@name='customer_id']/following-sibling::button)[2]");
//    private final By SelectClient = By.cssSelector("a#bs-select-7-0");
    /***************************************************************************************************************************************************/
    private final By SaveGiftCard = By.cssSelector("div#gift_card-modal>div>div>div:nth-of-type(2)>form>div:nth-of-type(6)>button");

// customer_id
private static WebElement element=null;
    public static WebElement selectCustomer(WebDriver driver) throws InterruptedException {
        element =driver.findElement(By.name("customer_id"));
        Select skills = new Select(element);
        int dropdown_value= driver.findElements(By.cssSelector("#gift_card-modal > div > div > div.modal-body > form > div.form-group.customer_list > div > select > option")).size();
        System.out.println(dropdown_value);
        // #gift_card-modal > div > div > div.modal-body > form > div.form-group.customer_list > div > select > option:nth-child(2)
        Random random3=new Random();
        int index= random3.nextInt(dropdown_value);
        skills.selectByVisibleText("marcelin");
        System.out.println(index);
        Thread.sleep(5000);
        return element;
    }
    @Step(" add GiftCard")
    public HomeScreen addGiftCard() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 2000);
//        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(AddGiftCard).click();
        driver.findElement(GenerateCardId).click();
        driver.findElement(AddGiftValue).sendKeys("5000");
        Thread.sleep(2000);
        selectCustomer(driver);
        driver.findElement(SaveGiftCard).click();

        return new HomeScreen(driver);
    }

}
