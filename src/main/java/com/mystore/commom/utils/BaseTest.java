package com.mystore.commom.utils;

import java.io.*;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest{
	
	String ENV="staging";
	
	Properties prop;
	static String URL;
	static String BROWSER;
	public BaseTest() throws Exception{ 
		prop = new Properties();
		InputStream input = null;
		String file = "testData.properties";
		
		input = new FileInputStream("src/main/resources/"+ENV+"/config/testData.properties");
		//Reader reader = new InputStreamReader(getClass().getResourceAsStream("/" + file), "UTF-8");
		prop.load(input);
		URL= (String) prop.get("URL");
		BROWSER= (String) prop.get("BROWSER");
	}
	
	
	
	public WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void setup(String brws){
		
		if(brws.equals("chrome")){
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 2"); 
		driver =new ChromeDriver();
				
		}
		driver.get(URL);
	}

	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
