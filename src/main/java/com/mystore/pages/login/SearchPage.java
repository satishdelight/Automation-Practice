package com.mystore.pages.login;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mystore.interfaces.home.SearchPageInterface;

public class SearchPage implements SearchPageInterface{
		
		WebDriver driver;
		public SearchPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}
		public String ResultFound(String searchText) {											
			//
		/*
		 * WebElement result =
		 * driver.findElement(By.xpath("//a[@class='product-name' and @title='"
		 * +searchText+"']"));
		 * 
		 * System.out.println(result.getText());
		 * 
		 * return result.getText();
		 */
			List<String> toBeSearched = new ArrayList<String>();
			toBeSearched.add(searchText);
			List<WebElement> result = driver.findElements(By.xpath("//a[@class='product-name' and @title='"+searchText+"']"));
//			
//			for(WebElement cartItemElement: cartItemElements) {
//				cartItems.add(cartItemElement.getText());
			
			result.containsAll(toBeSearched);
				
		    return searchText;
				
		}
	
}
			
			
		
	

