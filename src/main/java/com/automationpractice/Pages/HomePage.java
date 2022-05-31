package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public String baseUrl = "http://automationpractice.com/";
    @FindBy(css = "a.login")
    private WebElement signInButton;
    @FindBy(css = "#homefeatured h5>a[href*='id_product=1']")
    private WebElement firstProductLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigateToHomePage() {
        driver.get(baseUrl);
        return new HomePage(driver);
    }

    public LogInPage clickSignInButton() {
        signInButton.click();
        return new LogInPage(driver);
    }

    public ProductPage clickFirstItemLink() {
        firstProductLink.click();
        return new ProductPage(driver);
    }
}
