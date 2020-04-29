package com.mystore.common.utils;

import java.io.FileReader;
import java.util.Properties;

public class ProperitiesUtilBySudheer {

	Properties properties;
	String filePath;
	
	public ProperitiesUtilBySudheer(String fPath) {
		filePath = fPath;
		
		//Load the proeprties file
		properties = new Properties();
		
		try{
		FileReader reader = new FileReader(filePath);
		properties.load(reader);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getPropertyValue(String key)
	{
		return properties.getProperty(key);
	}
	
}
