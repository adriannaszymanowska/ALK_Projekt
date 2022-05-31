package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage extends BasePage {
    private final WebDriverWait wait;
    @FindBy(css = "button[name='processAddress']")
    private WebElement proceedToCheckoutButton;

    public AddressPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public ShippingPage clickProceedToCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton)).click();
        return new ShippingPage(driver);
    }
}
