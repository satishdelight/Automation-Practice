package com.mystore.tests.home;

import java.util.List;
import org.testng.annotations.Test;

import com.mystore.commom.utils.CommonMethods;
import com.mystore.commom.utils.BaseTest;

import com.mystore.pages.login.CartPage;
import com.mystore.pages.login.HomePage;

public class validatecartitems extends BaseTest{
	
CommonMethods commonMethodObj=new CommonMethods();
	
   /* @DataProvider(name = "SEARCH_PRODUCT")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=commonMethodObj.getTableArray("test-data/AmazonTestData.xls",
                "Products", "popularProduct");
        return(retObjArr);
    }*/
	
	
	public validatecartitems() throws Exception {
		super(); 
		
	}
    
	//you just initalized web driver in this class which is empty so it throws null pointer
	CartPage cartPage;
	HomePage homePage;
	
	@Test
	public void testCartItems() throws InterruptedException {
	
	//add items to cart	
	 homePage = new HomePage(driver);
	 cartPage = new CartPage(driver);
	 
	 List<String> addedProductToCart = homePage.addProductToCart();
	 homePage.clickCart();
	 
	 List<String> cartProducts = cartPage.getCartItems();
	 
	 addedProductToCart.containsAll(cartProducts);
     	
	}
	
	

}
