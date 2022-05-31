package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
    @FindBy(css = "p.alert-success")
    public WebElement orderConfirmationMessage;
    @FindBy(css = "a.cheque")
    private WebElement payByCheck;
    @FindBy(css = "p>button[type='submit']")
    private WebElement confirmOrderButton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage clickPayByCheck() {
        payByCheck.click();
        return new PaymentPage(driver);
    }

    public PaymentPage clickConfirmOrderButton() {
        confirmOrderButton.click();
        return new PaymentPage(driver);
    }
}
