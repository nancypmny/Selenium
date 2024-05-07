package rahulshettyacademy.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.Testcomponents.Basictest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.Landingpage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class stepDefinationImpl extends Basictest {
	
	public Landingpage landing;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		landing = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
		public void Logged_in_with_username_and_password(String username, String password) {
			productCatalogue = landing.loginApplication(username,password);
		}
	
	@When("^I add a product (.+) to cart$")
	public void I_add_a_product_to_cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getproductlist();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^checkout (.+) and Submit the order$")
	public void checkout_and_Submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string) {
     	String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
   
    	Assert.assertEquals(strArg1, landing.errorhandle());
    	driver.close();
    }


}
