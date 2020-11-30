package com.crm.qa.functionalTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.PageRepository.HomePage;
import com.crm.qa.PageRepository.LoginLandingPage;
import com.crm.qa.PageRepository.LoginPage;
import com.crm.qa.base.TestBase;


public class LoginLandingPageTest extends TestBase{
	//LoginLandingPageTest landingObj= new LoginLandingPageTest();
	public  LoginLandingPage loginLandingPg=new LoginLandingPage();
	LoginPage loginPg=new LoginPage() ;
	
	public LoginLandingPageTest() {
	super();// TODO Auto-generated constructor stub
	System.out.println("Super exited");
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
	@Test(priority=1)
	public void LandingPageTitleTest() {
		loginLandingPg.LoginLandingPageTitle();
	}
	@Test(priority=2)
	public void CRMlogoTest() {
		loginLandingPg.CRMLogo();
		}
	@Test(priority=3)
	public  void LandingLoginTest() {
		loginLandingPg.LandingLogin();
		//loginPg=loginLandingPg.LoginToCRM();
		//return new HomePage();
	}
@AfterMethod
public void tearDown() {
	
	driver.quit();
}
}
