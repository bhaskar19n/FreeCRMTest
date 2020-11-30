package com.crm.qa.PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase
{

	public SignUpPage() {//current page class pageFactory "Constructor" has to be defined--
		PageFactory.initElements(driver, this);
	}
	
/*	@FindBy(className="btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30")
	WebElement signUpBtn;*/
	@FindBy(xpath="//input[@id='email']")
	WebElement emailID;
	
	@FindBy(xpath="//input[@class='search']")
	WebElement countrySearchDropDown;
	
	@FindBy(xpath="//div[contains(text(),'India (+91)')]")
	WebElement countryCode;
	
	@FindBy(xpath="//input[@id='phone_number']")
	WebElement mobilerNo;
	
	@FindBy(xpath="//input[@id='terms']")
	WebElement termsCondition;
	
	@FindBy(xpath="//div[@class='g-recaptcha']")
	WebElement captchText;
	
	@FindBy(xpath="//button[@name='action']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//input[@placeholder='Verification Code']")
	WebElement verificationCode;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//button[@name='action']")
	WebElement verifyEmailbtn;
	
	@FindBy(xpath="//a[contains(text(),'Got an account? Log in here')]")
	WebElement loginHereLink;
	
}
