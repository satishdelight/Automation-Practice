package com.mystore.commom.utils;

import java.io.*;
import java.util.*;

public class ReadProperty {
	
	public void readUrl() throws Exception{
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/main/resources/configtestData.properties");
		prop.load(input);
		prop.get("URL");
	}

}