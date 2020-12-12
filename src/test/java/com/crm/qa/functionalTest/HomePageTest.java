package com.crm.qa.functionalTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.PageRepository.HomePage;
import com.crm.qa.PageRepository.LoginLandingPage;
import com.crm.qa.PageRepository.LoginPage;
import com.crm.qa.base.TestBase;

public class HomePageTest extends TestBase
{
	LoginLandingPage landingLoginObject;
	//HomePage homePgObj=new HomePage();
	LoginPageTest loginPgTestObj;
	public LoginPage LoginPage;
	public HomePageTest() {
		super();
}
	
	@BeforeMethod
	public void launchApplicationTest() throws InterruptedException {
		
			initialization();

		landingLoginObject=new LoginLandingPage();
		landingLoginObject.LandingLogin();
		//loginPgTestObj= new LoginPageTest();
		//loginPgTestObj.LoginToCRMtest();
		
		LoginPage= new LoginPage();
		LoginPage.LoginToCRM(prop.getProperty("username"), prop.getProperty("password"));
		//loginPgTestObj.LoginToCRMtest().
		//homePgObj=loginPgTestObj.LoginToCRMtest();
	}
	
	@Test
	public static void contactListTest() {
		
		HomePage.contactBoxCheck();
		
		
	}
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
