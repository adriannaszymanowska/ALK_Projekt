package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CreateAnAccountPage extends BasePage {
    private final WebDriverWait wait;
    @FindBy(css = "input#id_gender1")
    private WebElement genderMaleRadioButton;
    @FindBy(css = "input#id_gender2")
    private WebElement genderFemaleRadioButton;
    @FindBy(css = "input#customer_firstname")
    private WebElement firstNameInput;
    @FindBy(css = "input#customer_lastname")
    private WebElement lastNameInput;
    @FindBy(css = "input#passwd")
    private WebElement passwordInput;
    @FindBy(css = "select#days")
    private WebElement dayOfBirthSelect;
    @FindBy(css = "select#months")
    private WebElement monthOfBirthSelect;
    @FindBy(css = "select#years")
    private WebElement yearOfBirthSelect;
    @FindBy(css = "input#address1")
    private WebElement streetAddressInput;
    @FindBy(css = "input#city")
    private WebElement cityInput;
    @FindBy(css = "select#id_state")
    private WebElement stateInput;
    @FindBy(css = "input#postcode")
    private WebElement zipCodeInput;
    @FindBy(css = "input#phone_mobile")
    private WebElement mobilePhoneNumberInput;
    @FindBy(css = "button#submitAccount")
    private WebElement registerButton;
    @FindBy(css = "div.alert-danger li")
    private WebElement errorMessage;
    @FindBy(css = "div.alert-danger li")
    private List<WebElement> errorMessages;

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public CreateAnAccountPage chooseGender(String gender) {
        wait.until(ExpectedConditions.visibilityOf(genderMaleRadioButton));
        if (gender == "male") {
            genderMaleRadioButton.click();
        } else {
            genderFemaleRadioButton.click();
        }
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage selectDateOfBirth(Date birthdayDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] birthdayDateSplitted = (dateFormat.format(birthdayDate)).split("-");
        String year = birthdayDateSplitted[0];
        String month = birthdayDateSplitted[1];
        month = month.startsWith("0") ? month.substring(1) : month;
        String day = birthdayDateSplitted[2];
        day = day.startsWith("0") ? day.substring(1) : day;
        Select dayOfBirthSelect = new Select(this.dayOfBirthSelect);
        dayOfBirthSelect.selectByValue(day);
        Select monthOfBirthSelect = new Select(this.monthOfBirthSelect);
        monthOfBirthSelect.selectByValue(month);
        Select yearOfBirthSelect = new Select(this.yearOfBirthSelect);
        yearOfBirthSelect.selectByValue(year);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage fillAddress(String streetAddress) {
        streetAddressInput.sendKeys(streetAddress);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage fillCity(String city) {
        cityInput.sendKeys(city);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage selectState(String state) {
        Select stateSelect = new Select(stateInput);
        stateSelect.selectByVisibleText(state);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage fillZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage fillMobilePhoneNumber(String mobilePhoneNumber) {
        mobilePhoneNumberInput.sendKeys(mobilePhoneNumber);
        return new CreateAnAccountPage(driver);
    }

    public CreateAnAccountPage clickRegisterButton() {
        registerButton.click();
        return new CreateAnAccountPage(driver);
    }

    public AddressPage clickRegister() {
        registerButton.click();
        return new AddressPage(driver);
    }

    public boolean isPasswordErrorDisplayed() {
        int numberOfErrors = errorMessages.size();
        return numberOfErrors == 1 && errorMessage.getText().contains("passwd is required.");
    }
}
