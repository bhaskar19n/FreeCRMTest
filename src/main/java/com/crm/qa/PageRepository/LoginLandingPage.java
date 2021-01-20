package com.crm.qa.PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginLandingPage extends TestBase{

	public LoginLandingPage() {//current page class pageFactory "Constructor" has to be defined--
		PageFactory.initElements(driver, this);
	}
	//public static WebDriver driver;
		
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	public  WebElement landingPageLoginBtn;
	
	@FindBy(xpath="//a[@class='brand-name']")
	////div[@class='rd-navbar-panel']//div[@class='rd-navbar-brand']
	public WebElement crmLogo;
	//Inialization of page factory

	@Step("Step1:LoginLandingPageTitle")
	public String LoginLandingPageTitle() {
		return driver.getTitle();
	}
	@Step("Step2:CRMLogo")
	public boolean CRMLogo() {
		return crmLogo.isDisplayed();
		
	}
	@Step("Step3:LandingLogin")
	public  void LandingLogin() {
		landingPageLoginBtn.click();
		//return new LoginPage();
	}

}
