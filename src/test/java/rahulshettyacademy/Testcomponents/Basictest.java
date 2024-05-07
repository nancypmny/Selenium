package rahulshettyacademy.Testcomponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobject.Landingpage;

public class Basictest {
	
	public WebDriver driver;
	public Landingpage landing;
		
		public WebDriver initializeDriver() throws IOException {
			
			//properties class
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
			prop.load(fis);
			
			String browserName = prop.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver","F:\\ews\\msedgedriver.exe" );
				driver = new EdgeDriver();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			return driver;
		}
		@BeforeMethod(alwaysRun = true)
		public Landingpage launchApplication() throws IOException {
			driver = initializeDriver();
			landing = new Landingpage(driver);
			landing.togo();
			return landing;
		}
		
		@AfterMethod(alwaysRun = true)
		public void turnoff() {
			driver.close();
		}
		
		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		}
		
		public List<HashMap<String, String>> getJasonDataToMap(String filepath) throws IOException {
			
			//Jason to String
			String jasonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshetty\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);

	        //String to Hashmap
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String,String>> data = mapper.readValue(jasonContent, new TypeReference<List<HashMap<String,String>>>(){});
				return data;	

		}
		
		


}
