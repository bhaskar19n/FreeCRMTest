package com.crm.qa.functionalTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.PageRepository.LoginLandingPage;
import com.crm.qa.base.TestBase;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class LoginLandingPageTest extends TestBase{
	public  LoginLandingPage loginLandingPg= new LoginLandingPage();
	
	
	public LoginLandingPageTest() {
		super();// TODO Auto-generated constructor stub
		System.out.println("Super from Landing login exited");
}
	@BeforeMethod
	public  void launchApplicatonTest() throws InterruptedException{
		try {
			System.out.println("Entering Initalization() method");
			initialization();
			//loginLandingPg= new LoginLandingPage();
			//loginLandingPg= new LoginLandingPage(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Initalization() called");
	
	}
	
	//@Test(priority=1,retryAnalyzer=com.crm.qa.Analyzer.FailedReExecute.class)
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Allure- Verify application title page")
	public void LandingPageTitleTest() {
		loginLandingPg.LoginLandingPageTitle();
		System.out.println("Exiting from Landing Login Page title test");
		System.out.println("========================");
	/*	System.out.println("Entering CRM logo check");
		System.out.println("-------------------------------");
		loginLandingPg.CRMLogo();
		System.out.println("Entering Landing Logimn test");
		loginLandingPg.LandingLogin();*/
	}
	//@Test(priority=2,retryAnalyzer=com.crm.qa.Analyzer.FailedReExecute.class)
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Allure- Verify Logo test")
	public void CRMlogoTest() {
	loginLandingPg=new LoginLandingPage();
		System.out.println("Entering CRM logo check");
		loginLandingPg.CRMLogo();
		}
	//@Test(priority=3,retryAnalyzer=com.crm.qa.Analyzer.FailedReExecute.class)
	@Test(priority=3)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Allure- Login to application")
	@Story("Story: - To check Login")
	public  void LandingLoginTest() {
		loginLandingPg=new LoginLandingPage();
		System.out.println("Entered landing login() method");
		loginLandingPg.LandingLogin();
		//loginPg=loginLandingPg.LoginToCRM();
		//return new HomePage();
		//return new LoginPageTest();
	}
@AfterMethod
public void tearDown() {
	
	driver.quit();
}
}
