package com.mystore.tests.home;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.common.utils.BaseTest;
import com.mystore.common.utils.CommonMethods;
import com.mystore.pages.login.CartPage;
import com.mystore.pages.login.HomePage;

@Test
public class DeleteProduct extends BaseTest {
	
	public DeleteProduct() throws Exception {
		super(); 
		
	}
	CartPage cartPage;
	HomePage homePage;
	
   CommonMethods commonMethodObj=new CommonMethods();
	
    @DataProvider(name = "SEARCH_PRODUCT")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=commonMethodObj.getTableArray("test-data/AmazonTestData.xls",
                "Products", "searchProduct");
        return(retObjArr);
    }
    
    List<String> addedProductToCart = new ArrayList<String>();
    @Test(dataProvider="SEARCH_PRODUCT")
    public void addproduct(String addProduct)
    {
	addedProductToCart.add(addProduct);	
	
    }
    
	
    @Test(dataProvider="SEARCH_PRODUCT")
	public void deleteOneProduct(String addProduct) throws InterruptedException
	{
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		 
		
		System.out.print(addedProductToCart);
	
		
		
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//mouseover to cart
		 WebElement cart = driver.findElement(By.xpath("//a[contains(@title,'View my shopping cart')]"));
	       
		 Actions builder = new Actions(driver);
         Action mouseOverHome = builder
                 .moveToElement(cart).build();
         
         mouseOverHome.perform();
                 
         Thread.sleep(2000);
        
         Thread.sleep(2000);
		
		
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
        
        //deleteProduct
       
        homePage.deleteProductFromCart("Blouse");
		 
	}
}
