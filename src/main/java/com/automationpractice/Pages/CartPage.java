package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {
    private final WebDriverWait wait;
    @FindBy(css = "p.alert-warning")
    public WebElement warningMessage;
    @FindBy(css = "span#summary_products_quantity")
    public WebElement summaryProductQuantity;
    @FindBy(css = "i.icon-trash")
    private WebElement deleteIcon;
    @FindBy(css = "p>a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = "input.cart_quantity_input")
    private WebElement numberOfProductsInput;
    @FindBy(css = "a>span.ajax_cart_quantity")
    private WebElement itemsInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public CartPage clickDeleteIcon() {
        deleteIcon.click();
        wait.until(ExpectedConditions.attributeContains(itemsInCart, "class", "unvisible"));
        return new CartPage(driver);
    }

    public LogInPage clickProceedToCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton)).click();
        return new LogInPage(driver);
    }

    public CartPage changeNumberOfProducts(int numberOfProducts) {
        numberOfProductsInput.clear();
        numberOfProductsInput.sendKeys(Integer.toString(numberOfProducts));
        wait.until(ExpectedConditions.textToBePresentInElement(itemsInCart, "10"));
        return new CartPage(driver);
    }
}
