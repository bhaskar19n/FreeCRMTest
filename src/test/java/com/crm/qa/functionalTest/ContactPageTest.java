package com.crm.qa.functionalTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.PageRepository.ContactPage;
import com.crm.qa.PageRepository.HomePage;
import com.crm.qa.PageRepository.LoginLandingPage;
import com.crm.qa.PageRepository.LoginPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class ContactPageTest extends TestBase {
	public static LoginLandingPageTest LandingLoginTestObj;
	LoginLandingPage landingLoginPgOb;
	public  LoginPage LoginPg;
	HomePage homePg = new HomePage();
	ContactPage contactPg;
	TestUtil testUtil;

	String sheetName="AddContacts"; 

	public  ContactPageTest() {
		super();
	}


	@BeforeTest
	public void launchApplication() {
		try {
			initialization();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		testUtil= new TestUtil();
		contactPg= new ContactPage();
		//landingLoginPgOb=new LoginLandingPage();
		//landingLoginPgOb.LandingLogin();
	
		LandingLoginTestObj=new LoginLandingPageTest();
		LandingLoginTestObj.LandingLoginTest();
	 	//LoginPg=new LoginPage();
		//LoginPage.LoginToCRM(prop.getProperty("username"),prop.getProperty("password"));
				
		homePg=new HomePage();homePg=
				LoginPg.LoginToCRM(prop.getProperty("username"),prop.getProperty("password"));
		contactPg=homePg.ClickContactLink();

	}

	@Test(priority=1)
	public void ContactLinkNavigationTest() {
		///String contactPgTitle= contactPg.ContactsPageLabel;
		contactPg=homePg.ClickContactLink();
		System.out.println("Contact Page - Header test start");
		Assert.assertTrue(contactPg.ConatctPgHeader(),"Contact Page header title is not displayed");
		System.out.println("Contact Page - Header test END");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=2,dataProvider="getCRMTestData")
	public void NewContactTest(String FirstName, String LastName, String Company) {
		contactPg.NewBtn.click();
		contactPg.createNewContact(FirstName, LastName, Company);
		Assert.assertTrue(ContactPage.contactPhtoto.isDisplayed(),"Contact Avatar is not displayed");
		ContactLinkNavigationTest();
	}
	
}
