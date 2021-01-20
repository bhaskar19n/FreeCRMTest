package com.crm.qa.PageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;

import com.crm.qa.base.TestBase;

import io.qameta.allure.Step;

public class ContactPage extends TestBase{
	public ContactPage(){
	PageFactory.initElements(driver, this);
	}
	
	//
	//@FindBy(xpath="//div[contains(text(),'Contacts')]")	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	public  WebElement ContactsPageLabel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	public WebElement NewBtn;
	
	@FindBy(xpath="//input[@name='first_name']")
	public WebElement FirstNameField;
	
	@FindBy(xpath="//input[@name='last_name']")
	public WebElement LastNameField;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	public WebElement companyField;
	
	@FindBy(xpath="//div[@class='selected item addition']//span[@class='text'][contains(text(),'Add')]")
	public WebElement addCompanyLink;
	
	@FindBy(xpath="//div[@class='selected item addition']")
	public WebElement addLink;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath="//i[@class='large user red icon']")
	public static WebElement contactPhtoto;
	//================================================
	@Step("Step1:Contact page header")
		public boolean ConatctPgHeader() {
		return ContactsPageLabel.isDisplayed();
	}
	@Step("Create new contact using fn{0} , ln{1}, comp{2}")
	public void createNewContact(String fn,String ln, String comp) {
		
		FirstNameField.sendKeys(fn);
		LastNameField.sendKeys(ln);
		companyField.sendKeys(comp);
		/*Select addLinkSelect = new Select(addLink);
		addLinkSelect.selectByVisibleText("Add");*/
		addCompanyLink.click();
		System.out.println("Added company");
		//((WebElement) addLinkSelect).click();
		saveBtn.click();
	}
}
