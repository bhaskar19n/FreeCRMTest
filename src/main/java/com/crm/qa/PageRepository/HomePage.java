package com.crm.qa.PageRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	//HomePage homePgObj;
	public HomePage() {
	PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//div[@class='vertical-timeline-element-content bounce-in']")
	//public static  WebElement contactBox;
	@FindBy(xpath="//a[contains(text(),'Bhaskar K')]")
	public static  WebElement contactName;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	public static void contactBoxCheck() {
		/* HomePage homePgObj=PageFactory.initElements(driver, HomePage.class);
		Assert.assertTrue(((WebElement) homePgObj).isDisplayed(),"ConatctBox is not displayed");*/
		//System.out.println("ConatctBox is displayed "+contactName.isDisplayed());
		//Assert.assertTrue(contactBox.isDisplayed(), "contactBox is not displayed");
		System.out.println("Contact Box");
	}

	

	public ContactPage ClickContactLink() {

		ContactsLink.click();
		return new ContactPage();
	}
}
