import com.automationpractice.Base.ExtentTestManager;
import com.automationpractice.Pages.CartPage;
import com.automationpractice.Pages.HomePage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.automationpractice.Base.TestListener.class)

public class TC03RemoveProductFromCart extends BaseTest {
    public HomePage homePage;

    @Test
    public void removeProductFromCartTest() {
        homePage = new HomePage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Test starts");
        CartPage cartPage = homePage
                .navigateToHomePage()
                .clickFirstItemLink()
                .clickAddToCartButton()
                .clickProceedToCheckoutButton()
                .clickDeleteIcon();
        ExtentTestManager.getTest().log(Status.INFO, "Steps are finished");

        Assert.assertEquals(cartPage.warningMessage.getText(),
                "Your shopping cart is empty.",
                "Cart is not empty.");
    }
}