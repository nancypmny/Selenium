package rahulshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Landingpage extends AbstractComponents{
	
	WebDriver driver;

	public Landingpage(WebDriver driver) {
		
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		// TODO Auto-generated method stub
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement password;
		
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		public ProductCatalogue loginApplication(String email,String Password) {
			userEmail.sendKeys(email);
			password.sendKeys(Password);
			submit.click();
			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			return productCatalogue;
			
		}
		public void togo() {
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		public String errorhandle() {
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}

	

}
