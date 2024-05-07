package rahulshettyacademy.pageobjects;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.Testcomponents.Basictest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.ProductCatalogue;



public class Errorhandlingproject extends Basictest {
	
	@Test(groups = {"ErrorHandling"}, retryAnalyzer = rahulshettyacademy.Testcomponents.Retry.class)
	public void submitOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		landing.loginApplication("saininancy110@gmail.com", "rahulSel4");
		Assert.assertEquals("Incorrect email or pas@sword.", landing.errorhandle())	;				
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landing.loginApplication("rahulshetty@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogue.getproductlist();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}

}
