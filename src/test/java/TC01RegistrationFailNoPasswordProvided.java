import com.automationpractice.Base.ExtentTestManager;
import com.automationpractice.Pages.CreateAnAccountPage;
import com.automationpractice.Pages.HomePage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.automationpractice.Base.TestListener.class)


public class TC01RegistrationFailNoPasswordProvided extends BaseTest {
    public HomePage homePage;

    @Test
    public void RegistrationFailNoPasswordProvidedTest() {
        homePage = new HomePage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Test starts");
        CreateAnAccountPage createAnAccountPage = homePage
                .navigateToHomePage()
                .clickSignInButton()
                .fillEmailAddressInput(testData.emailAddress)
                .clickCreateAnAccountButton()
                .chooseGender(testData.gender)
                .fillFirstName(testData.firstName)
                .fillLastName(testData.lastName)
                .selectDateOfBirth(testData.dateOfBirth)
                .fillAddress(testData.streetAddress)
                .fillCity(testData.city)
                .selectState(testData.state)
                .fillZipCode(testData.zipCode)
                .fillMobilePhoneNumber(testData.mobilePhoneNumber)
                .clickRegisterButton();
        ExtentTestManager.getTest().log(Status.INFO, "Steps are finished");

        Assert.assertTrue(createAnAccountPage.isPasswordErrorDisplayed(),
                "There is no password error or there is more than one error.");
    }
}