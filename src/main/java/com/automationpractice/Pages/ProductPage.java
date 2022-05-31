package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {
    private final WebDriverWait wait;
    @FindBy(css = "span#layer_cart_product_quantity")
    public WebElement quantityOfProductsInCart;
    @FindBy(css = "a[title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;
    @FindBy(css = "button.exclusive")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public ProductPage clickAddToCartButton() {
        addToCartButton.click();
        wait.until(ExpectedConditions.attributeContains(addToCartButton, "class", "added"));
        return new ProductPage(driver);
    }

    public CartPage clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
        return new CartPage(driver);
    }
}
