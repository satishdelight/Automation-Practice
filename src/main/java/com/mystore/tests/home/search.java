package com.mystore.tests.home;

import com.mystore.common.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pages.login.HomePage;
import com.mystore.pages.login.SearchPage;
import com.mystore.common.utils.CommonMethods;

public class search extends BaseTest{

	public search() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
//button[  @name="submit_search"]

//a[@title="Blouse" and @class="product_img_link"]	

   // WebDriver driver;
	CommonMethods commonMethodObj=new CommonMethods();
	
    @DataProvider(name = "SEARCH_PRODUCT")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=commonMethodObj.getTableArray("test-data/AmazonTestData.xls",
                "Products", "searchProduct");
		return (retObjArr);
       
        
    }
    
   
    
    @Test(dataProvider="SEARCH_PRODUCT")
    
	public void ResultFound(String searchText) {
		
		SearchPage searchPageObj=new SearchPage(driver);
		
		HomePage homePageObj=new HomePage(driver);
		
		homePageObj.searchBox(searchText);
		
		String result=searchPageObj.ResultFound(searchText);
		
		Assert.assertEquals(result, searchText);
			
		
	}
    
}
