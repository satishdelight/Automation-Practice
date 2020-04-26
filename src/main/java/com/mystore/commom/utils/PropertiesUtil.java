package com.mystore.commom.utils;

import java.io.*;
import java.util.*;

public class PropertiesUtil {
	   
    private static Properties properties = null;

       public PropertiesUtil(final String file) {
           try {
               properties = new Properties();
               //Reader reader = new InputStreamReader(getClass().getResourceAsStream("/" + file), "UTF-8");
               InputStream input = null;
               input = new FileInputStream(file);
               properties.load(input);

           } catch (Exception e) {
               e.printStackTrace();
           }
       }

       public String getValue(final String propertyKey) {
           return properties.getProperty(propertyKey);
       }

       public String setValue(final String propertyKey, final String propertyValue) {
           return (String) properties.setProperty(propertyKey, propertyValue);
       }

}
 