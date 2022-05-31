import com.automationpractice.Base.ExtentTestManager;
import com.automationpractice.Pages.HomePage;
import com.automationpractice.Pages.ProductPage;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.automationpractice.Base.TestListener.class)

public class TC02AddProductToCart extends BaseTest {
    public HomePage homePage;

    @Test
    public void addProductToCartTest() {
        homePage = new HomePage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Test starts");
        ProductPage productPage = homePage
                .navigateToHomePage()
                .clickFirstItemLink()
                .clickAddToCartButton();
        ExtentTestManager.getTest().log(Status.INFO, "Steps are finished");

        Assert.assertEquals(productPage.quantityOfProductsInCart.getText(),
                "1",
                "Product was not added to cart.");
    }
}
