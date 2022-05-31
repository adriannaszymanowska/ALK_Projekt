package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingPage extends BasePage {
    private final WebDriverWait wait;
    @FindBy(css = "input[type='checkbox']")
    private WebElement termsOfServiceCheckbox;
    @FindBy(css = "button[name='processCarrier']")
    private WebElement proceedToCheckoutButton;

    public ShippingPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public ShippingPage acceptTermsOfService() {
        termsOfServiceCheckbox.click();
        return new ShippingPage(driver);
    }

    public PaymentPage clickProceedToCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton)).click();
        return new PaymentPage(driver);
    }
}
