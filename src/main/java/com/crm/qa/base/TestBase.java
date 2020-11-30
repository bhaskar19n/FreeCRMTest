package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utils.TestUtil;
import com.crm.qa.utils.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fin;
	public static EventFiringWebDriver eventFiring_Driver;
	public static WebEventListener eventListner;
	 
	public TestBase() {
		try {
		 prop= new Properties(); 	
		 String current = System.getProperty("user.dir");//Current working directory in Java : E:\Selenium2020\FreeCRMTest
		 fin = new FileInputStream(current+"/src/main/java/com/crm/qa/properties/config.properties");
			prop.load(fin);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() throws InterruptedException{
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium2020\\Chrome driver 85\\chromedriver.exe");
			 driver = new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium2020\\geckodriver.exe");
			 driver = new FirefoxDriver();
		
		}
		
		 eventFiring_Driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		 eventListner= new WebEventListener();
		 eventFiring_Driver.register(eventListner);
		 driver=eventFiring_Driver;
		 
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
