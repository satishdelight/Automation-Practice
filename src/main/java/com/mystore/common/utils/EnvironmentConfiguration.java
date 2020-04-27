package com.mystore.common.utils;


public final class EnvironmentConfiguration {

       private static PropertiesUtil propertiesUtil = new PropertiesUtil("src/main/resources/config/testData.properties");

       private EnvironmentConfiguration() {

       }

       public static String getValue(final String key) {
           return propertiesUtil.getValue(key);
       }
}