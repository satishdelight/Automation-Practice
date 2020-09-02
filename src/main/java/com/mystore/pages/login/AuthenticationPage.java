package com.mystore.pages.login;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.utils.ProperitiesUtilBySudheer;
import com.mystore.interfaces.home.HomePageInterface;


public class  AuthenticationPage implements HomePageInterface {
	ProperitiesUtilBySudheer propUtil = new ProperitiesUtilBySudheer("object.properties");
	 WebDriver driver;
	
	public AuthenticationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);   
	}

 
	
	public void login(String username, String password)
	{
	    WebElement uname = driver.findElement(By.xpath("AuthenticationTest_enterEmailAddress_xpath"));
	    uname.click();
	    uname.clear();
	    uname.sendKeys(username); 
	    
	    WebElement pword = driver.findElement(By.xpath("AuthenticationTest_enterpassword_xpath"));
	    pword.click();
	    uname.clear();
	    uname.sendKeys(password); 
	    
	}



	public void clickCart() {
		// TODO Auto-generated method stub
		
	}



	public List<String> addProductToCart() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}



	public void deleteProductFromCart(String ProductToBeDeleted) {
		// TODO Auto-generated method stub
		
	}



	public void searchBox(String searchText) {
		// TODO Auto-generated method stub
		
	}



	public void signin() {
		// TODO Auto-generated method stub
		
	}
	
	
}
