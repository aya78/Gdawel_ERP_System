package com.sauceLabs.screens;

import cucumber.api.java.eo.Se;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GiftCardScreen extends HomeScreen {
    public GiftCardScreen(WebDriver driver) {
        super(driver);
    }
    private final By AddGiftCard = By.xpath("//button[text()[normalize-space()='إضافة بطاقة هدايا']]");
    // GiftCard
    // //div[@id='gift_card-modal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/button[1]
    private final By GenerateCardId = By.xpath("//div[@id='gift_card-modal']/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/button[1]");
    private final By AddGiftValue = By.xpath("//input[@type='number']");
    private final By ClickClients = By.xpath("(//select[@name='customer_id']/following-sibling::button)[2]");
    private final By SelectClient = By.cssSelector("a#bs-select-7-0");
    private final By SaveGiftCard = By.cssSelector("div#gift_card-modal>div>div>div:nth-of-type(2)>form>div:nth-of-type(6)>button");


    @Step(" add GiftCard")
    public HomeScreen addGiftCard() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.invisibilityOfAllElements());
        driver.findElement(AddGiftCard).click();
        driver.findElement(GenerateCardId).click();
        driver.findElement(AddGiftValue).sendKeys("5000");
        driver.findElement(ClickClients).click();
        driver.findElement(SelectClient).click();
        driver.findElement(SaveGiftCard).click();

        return new HomeScreen(driver);
    }

}
