package com.mystore.tests.home;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.common.utils.BaseTest;
import com.mystore.common.utils.CommonMethods;
import com.mystore.pages.login.AuthenticationPage;

public class AuthenticationTest extends BaseTest{
	
	public AuthenticationTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
    CommonMethods commonMethodObj=new CommonMethods();
	
    @DataProvider(name = "LOGIN_DATA")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=commonMethodObj.getTableArray("test-data/LoginData.xls",
                "usercreditentials", "Login");
        return(retObjArr);
    }
    
    @Test(dataProvider="LOGIN_DATA")  
	public void loginTest() {		
		Map<String, String> testData = new HashMap<String, String>();
		//enter all the password username combinations here 
		testData.put("satish", "password");// wrong username and wrong password
		testData.put("", ""); //empty username and empty password
		testData.put("satishdelight@gmail.com", "password"); // correct username and wrong password
		testData.put("test@gmail.com", "DELight@8"); // wrong username and correct password
		testData.put("satishdelight@gmail.com", "DELight@8"); // correct username and correct password
		int i =0;
    	AuthenticationPage authPageObj = new AuthenticationPage (driver);
    	
    	for(Map.Entry<String, String> entry: testData.entrySet()) {
    		if(i<3) {
    			authPageObj.login(entry.getKey(), entry.getValue());
    			//login error message
    			i++;
    		}else {
    			authPageObj.login(entry.getKey(), entry.getValue());
    			// success message validate
    		}
    	}
 
    }
}
