package com.mystore.pages.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mystore.interfaces.home.HomePageInterface;

import com.mystore.common.utils.ProperitiesUtilBySudheer;

public  class HomePage implements HomePageInterface{
	
    
	ProperitiesUtilBySudheer propUtil = new ProperitiesUtilBySudheer("object.properties");
	 WebDriver driver;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);   
	}  
	
	
	//@FindBy(xpath=("//ul[@id=\"homefeatured\"]//a[@class=\"product-name\" and @title=\"Faded Short Sleeve T-shirts\"]"))
	//WebElement clickProduct;
	
	public void clickCart() {
		// TODO Auto-generated method stub
		propUtil = new ProperitiesUtilBySudheer("src/main/resources/object.properties");
		WebElement clickCart =	driver.findElement(By.xpath(propUtil.getPropertyValue("homepage_clickcart_xpath")));
		
		clickCart.click();
	}
	
	public List<String> addProductToCart() throws InterruptedException {
		
		propUtil = new ProperitiesUtilBySudheer("src/main/resources/object.properties");
		
		List<String> selectedProductsFromPopular = new ArrayList<String>();
		
		selectedProductsFromPopular.add("Blouse");
		selectedProductsFromPopular.add("Faded Short Sleeve T-shirts");
		selectedProductsFromPopular.add("Printed Dress");
		 
 	
		List<WebElement> allProductsFromPopular=driver.findElements(By.xpath(propUtil.getPropertyValue("homepage_popularproducts_xpath")));
		
		List<String> allProducts = new ArrayList<String>();
		for (WebElement G : allProductsFromPopular) {
			allProducts.add(G.getText());	
		}
		
		//if(allProducts.containsAll(selectedProductsFromPotpular)) {
			
			for(int i=0;i<selectedProductsFromPopular.size();i++)
				
			{
				driver.findElement(By.xpath("//ul[@id='homefeatured']//a[@class='product-name' and @title='"+selectedProductsFromPopular.get(i)+"']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(propUtil.getPropertyValue("productpage_addtocart_xpath"))).click();
				
				Thread.sleep(2000);
				driver.findElement(By.xpath(propUtil.getPropertyValue("productpage_continueshopping_xpath"))).click();
				Thread.sleep(2000);
				driver.navigate().back();
			}
	
			return selectedProductsFromPopular;
	}
	
	/*
	 * public void deleteProductFromCart(String ProductToBeDeleted) {
	 * driver.findElement(By.
	 * xpath("//dt[contains(@data-id, 'cart_block_product')]//a[@title='"
	 * +ProductToBeDeleted+"']/..//div[@class='product-atributes']//a[text()='Black, S']/../../..//a[@class='ajax_cart_block_remove_link']"
	 * )).click();
	 * 
	 * }
	 */

	public void searchBox(String searchText) {
		// TODO Auto-generated method stub
		
		String value = propUtil.getPropertyValue("homepage_searchbox_xpath");
		System.out.print("driver = "+driver);
		WebElement password = driver.findElement(By.xpath(value));
		password.clear();
		((WebElement) password).sendKeys(searchText);
		
		/*
		 * WebElement o = driver.findElement(By.xpath("//span[text()='My account']"));
		 * if (o.isDisplayed()) { System.out.println(o); }
		 */
		
	
		//enter text to be searched
		WebElement clickSearchIcon = driver.findElement(By.xpath(propUtil.getPropertyValue("homepage_searchbutton_xpath")));
		clickSearchIcon.click();
		
	}


	public void deleteProductFromCart(String ProductToBeDeleted) {
		// TODO Auto-generated method stub
		
	}
	
	
	//navigaion to authentication page
	public void signin()
	{
		
		WebElement clicklogin = driver.findElement(By.xpath(propUtil.getPropertyValue("homepage_clickSign_xpath")));
		clicklogin.click();
		
	
	}

}
