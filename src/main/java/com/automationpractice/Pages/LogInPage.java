package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    @FindBy(css = "input#email_create")
    private WebElement emailInput;
    @FindBy(css = "button#SubmitCreate")
    private WebElement createAnAccountButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public LogInPage fillEmailAddressInput(String emailAddress) {
        emailInput.sendKeys(emailAddress);
        return new LogInPage(driver);
    }

    public CreateAnAccountPage clickCreateAnAccountButton() {
        createAnAccountButton.click();
        return new CreateAnAccountPage(driver);
    }
}

