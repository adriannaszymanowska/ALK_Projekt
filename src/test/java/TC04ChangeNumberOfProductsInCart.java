import com.automationpractice.Base.ExtentTestManager;
import com.automationpractice.Pages.CartPage;
import com.automationpractice.Pages.HomePage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.automationpractice.Base.TestListener.class)

public class TC04ChangeNumberOfProductsInCart extends BaseTest {
    public HomePage homePage;

    @Test
    public void changeNumberOfProductsInCartTest() {
        homePage = new HomePage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Test starts");
        CartPage cartPage = homePage
                .navigateToHomePage()
                .clickFirstItemLink()
                .clickAddToCartButton()
                .clickProceedToCheckoutButton()
                .changeNumberOfProducts(10);
        ExtentTestManager.getTest().log(Status.INFO, "Steps are finished");

        Assert.assertEquals(cartPage.summaryProductQuantity.getText(),
                "10 Products",
                "Number of products is not as expected.");
    }
}