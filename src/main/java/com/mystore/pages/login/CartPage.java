package com.mystore.pages.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.interfaces.home.CartPageInterface;


public class CartPage implements CartPageInterface{
	

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);   
	}

	@FindBy(xpath=("//table[@id ='cart_summary']//p[@class='product-name']//a"))
	List<WebElement> cartItemsxpath;
	
	 //String t = String.format("//ul[@id=\"homefeatured\"]//a[@class=\"product-name\"][%d]",i);
			
	public List<String> getCartItems() {
		List<String> cartItems = new ArrayList<String>();
		List<WebElement> cartItemElements = cartItemsxpath;
		for(WebElement cartItemElement: cartItemElements) {
			cartItems.add(cartItemElement.getText());
		}
		return cartItems;
		
		
	}
	
	
	
	

}
