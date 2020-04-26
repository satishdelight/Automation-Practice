package example;		

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://automationpractice.com");  
			String title = driver.getTitle();				 
			AssertJUnit.assertTrue(title.contains("My Store")); 		
		}	
		@BeforeTest
		public void beforeTest() {	
			
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 2");
			driver =new ChromeDriver(); 
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}
		//Test git push
}	