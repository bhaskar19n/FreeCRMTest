package com.crm.qa.PageRepository;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;



public class LoginPage extends TestBase{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='ui stacked segment']")
	WebElement LoginDetailSection;
	
	//@FindBy(xpath="placeholder='E-mail address'")
	//public  WebElement username;
	@FindBy(name="email")
	public  WebElement username;
	
	//input[@placeholder='E-mail address']
	@FindBy(name="password")
	public  WebElement pw;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	public  WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	public WebElement SignUpLink;
	
	public void VerifyLoginPageTitle() {
		String LoginPgTitle=driver.getTitle();
		Assert.assertEquals(LoginPgTitle, "Cogmento CRM");
		
	}
	public HomePage LoginToCRM(String un, String pwd) {
	/*	username.sendKeys(prop.getProperty("username"));
	 * 
		pw.sendKeys(prop.getProperty("password"));*/
		System.out.println("Entering Login to CRM from LoginPage");
		username.sendKeys(un);
		System.out.println("User name entered");
		pw.sendKeys(pwd);

		loginButton.click();
		return new HomePage();
	}
	 
	public SignUpPage signUp() {
		SignUpLink.click();
		return new SignUpPage();
		 
	}
}
