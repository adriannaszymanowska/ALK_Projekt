import com.automationpractice.Base.ExtentTestManager;
import com.automationpractice.Pages.HomePage;
import com.automationpractice.Pages.PaymentPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.automationpractice.Base.TestListener.class)

public class TC05BuyWithCreatingAccountPayByCheck extends BaseTest {
    public HomePage homePage;

    @Test
    public void buyWithCreatingAccountPayByCheckTest() {
        homePage = new HomePage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Test starts");
        PaymentPage paymentPage = homePage
                .navigateToHomePage()
                .clickFirstItemLink()
                .clickAddToCartButton()
                .clickProceedToCheckoutButton()
                .clickProceedToCheckoutButton()
                .fillEmailAddressInput(testData.emailAddress)
                .clickCreateAnAccountButton()
                .chooseGender(testData.gender)
                .fillFirstName(testData.firstName)
                .fillLastName(testData.lastName)
                .fillPassword(testData.password)
                .selectDateOfBirth(testData.dateOfBirth)
                .fillAddress(testData.streetAddress)
                .fillCity(testData.city)
                .selectState(testData.state)
                .fillZipCode(testData.zipCode)
                .fillMobilePhoneNumber(testData.mobilePhoneNumber)
                .clickRegister()
                .clickProceedToCheckoutButton()
                .acceptTermsOfService()
                .clickProceedToCheckoutButton()
                .clickPayByCheck()
                .clickConfirmOrderButton();
        ExtentTestManager.getTest().log(Status.INFO, "Steps are finished");

        Assert.assertEquals(paymentPage.orderConfirmationMessage.getText(),
                "Your order on My Store is complete.",
                "Order was not completed.");
    }
}
