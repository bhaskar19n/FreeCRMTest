package com.crm.qa.functionalTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.PageRepository.HomePage;
import com.crm.qa.PageRepository.LoginLandingPage;
import com.crm.qa.PageRepository.LoginPage;
import com.crm.qa.base.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends TestBase{
	public LoginLandingPage landingLgnPgObj;//= new LoginLandingPage();
	public LoginPage loginPgO;//= new LoginPage();
	//HomePage homePg;

	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void launchApplicatonTest() {
		System.out.println("Initialization() method called");
		try {
			initialization();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
}

/*public void justPrint() {
	System.out.println("Just [print");
	 LoginPage.LoginToCRM(null, null);//prop.getProperty("username"), prop.getProperty("password"));
}*/


@SuppressWarnings("static-access")
//@Test(retryAnalyzer=com.crm.qa.Analyzer.FailedReExecute.class)
@Test
@Severity(SeverityLevel.BLOCKER)
@Description("Login to CRM")
public  void LoginToCRMtest() {
	System.out.println("LoginPageTest=TestMethod called -Login to CRM method");
	landingLgnPgObj=new LoginLandingPage();
	landingLgnPgObj.LandingLogin();
	loginPgO = new LoginPage();
	loginPgO.LoginToCRM(prop.getProperty("username"), prop.getProperty("password"));
	//LoginPage.LoginToCRM(prop.getProperty("username"), prop.getProperty("password"));

	//loginPgO=new LoginPage();
//	landingLgnPgObj=new LoginLandingPage();
//	landingLgnPgObj.LandingLogin();
//		
//			   loginPgO.LoginToCRM(prop.getProperty("username"), prop.getProperty("password"));
	}
@AfterMethod
public void tearDown() {
	
	driver.quit();
}
}
