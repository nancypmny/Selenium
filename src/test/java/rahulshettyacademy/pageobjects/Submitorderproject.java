package rahulshettyacademy.pageobjects;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import rahulshettyacademy.Testcomponents.Basictest;
import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.Landingpage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.ProductCatalogue;



public class Submitorderproject extends Basictest{
	String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData", groups={"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException { //String email,String password, String productname
		// TODO Auto-generated method stub
		
	
		ProductCatalogue productCatalogue= landing.loginApplication(input.get("email"),input.get("password"));
		
		List<WebElement> products = productCatalogue.getproductlist();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
//		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
//		String confirmMessage = confirmationPage.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
//		String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));				
		
	}
    
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		//"ZARA COAT 3";
		ProductCatalogue productCatalogue = landing.loginApplication("anshika@gmail.com", "Iamking@000");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email","saininancy110@gmail.com" );
//		map.put("password","rahulSelenium4" );
//		map.put("productname", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("password","Iamking@000" );
//		map1.put("productname","ADIDAS ORIGINAL" );
		
		List<HashMap<String,String>> data = getJasonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshetty\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
//	@DataProvider
//	public Object[][] getData(){
//	     return new Object[][]  {{"saininancy110@gmail.com","rahulSelenium4","ZARA COAT 3"},{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//	}

}
