package com.mystore.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.interfaces.home.ProductPageInterface;

public class ProductPage implements ProductPageInterface{
	
    WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);   
	}

	@FindBy(xpath=("//button[@name=\"Submit\"]"))
	
	WebElement clickAddToCart;
	
	public void clickAddToCart() {
		// TODO Auto-generated method stub
		
	clickAddToCart.click();
		
	}

}
