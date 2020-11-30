package com.crm.qa.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public void PropertiesData() throws IOException {
		
		Properties prop= new Properties();
		FileInputStream fin= new FileInputStream("E:\\Selenium2020\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\properties\\properties");
		prop.load(fin);
		System.out.println("Browser name= "+prop.getProperty("browser"));
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			
			
		}
		prop.getProperty("url");
		
	}

}
