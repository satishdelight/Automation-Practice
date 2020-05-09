package com.mystore.pages.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mystore.common.utils.ProperitiesUtilBySudheer;
import com.mystore.interfaces.home.CartPageInterface;


public class CartPage implements CartPageInterface{
	
	WebDriver driver;
	ProperitiesUtilBySudheer propUtil;
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);   
	}

	
	 //String t = String.format("//ul[@id=\"homefeatured\"]//a[@class=\"product-name\"][%d]",i);
			
	public List<String> getCartItems() {
		
		propUtil = new ProperitiesUtilBySudheer("src/main/resources/object.properties");
		List<WebElement> cartItemsxpath=driver.findElements(By.xpath(propUtil.getPropertyValue("cartpage_cartitems_xpath")));
		List<String> cartItems = new ArrayList<String>();
		List<WebElement> cartItemElements = cartItemsxpath;
		for(WebElement cartItemElement: cartItemElements) {
			cartItems.add(cartItemElement.getText());
		}
		return cartItems;
	}
	
	
	
	

}
