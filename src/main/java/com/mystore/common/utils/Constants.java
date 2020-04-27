package com.mystore.common.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Constants{
	
	Properties prop;
	static String URL;
	static String BROWSER;
	String ENV;
	
	public Constants() throws Exception{ 
		prop = new Properties();
		InputStream input = null;
		String file = "testData.properties";
		input = new FileInputStream("/src/main/resources/"+ENV+"/config/testData.properties");
		//Reader reader = new InputStreamReader(getClass().getResourceAsStream("/" + file), "UTF-8");
		prop.load(input);
		URL= (String) prop.get("URL");
		BROWSER= (String) prop.get("BROWSER");
	}
	
	
}