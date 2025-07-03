package com.jktech.utils;

public class ApiUtils {
    public static String getBaseUri() {
    	ConfigReader config = new ConfigReader("src/test/resources/config.properties");
    	String baseURL =config.getProperty("base.url");
    	return baseURL;
    }
}