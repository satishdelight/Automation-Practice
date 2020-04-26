package com.mystore.pages.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.interfaces.home.HomePageInterface;

public class HomePage implements HomePageInterface{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);   
	}
	
	

	@FindBy(xpath=("//div[@class='shopping_cart']//b"))
	WebElement clickCart;
	
	
	//@FindBy(xpath=("//ul[@id=\"homefeatured\"]//a[@class=\"product-name\" and @title=\"Faded Short Sleeve T-shirts\"]"))
	//WebElement clickProduct;

	
	
	
	

	public void clickCart() {
		// TODO Auto-generated method stub
		clickCart.click();
	}
	
	public List<String> addProductToCart() throws InterruptedException {
		List<String> selectedProductsFromPopular = new ArrayList<String>();
		
		selectedProductsFromPopular.add("Blouse");
		selectedProductsFromPopular.add("Faded Short Sleeve T-shirts");
		selectedProductsFromPopular.add("Printed Dress");
		
 	
		List<WebElement> allProductsFromPopular=driver.findElements(By.xpath("//ul[@id='homefeatured']//a[@class='product-name']"));
		
		List<String> allProducts = new ArrayList<String>();
		for (WebElement G : allProductsFromPopular) {
			allProducts.add(G.getText());	
		}
		
		//if(allProducts.containsAll(selectedProductsFromPopular)) {
			
			for(int i=0;i<selectedProductsFromPopular.size();i++)
				
			{
				driver.findElement(By.xpath("//ul[@id='homefeatured']//a[@class='product-name' and @title='"+selectedProductsFromPopular.get(i)+"']")).click();
				Thread.sleep(20000);
				driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
				Thread.sleep(2000);
				driver.navigate().back();
			}
	
			return selectedProductsFromPopular;
	}
	
	public void deleteProductFromCart(String ProductToBeDeleted)
	{
		driver.findElement(By.xpath("//dt[contains(@data-id, 'cart_block_product')]//a[@title='"+ProductToBeDeleted+"']/..//div[@class='product-atributes']//a[text()='Black, S']/../../..//a[@class='ajax_cart_block_remove_link']")).click();
		
	}
	
	

}
