package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.factory.DriverFactory;

public class ContactsPage {
	
	private WebDriver driver;
	//1. By Locators : OR
	private By contacts = By.xpath("//span[contains(text(),'Contacts')]");
	private By newContact = By.xpath("//span[contains(text(),'Contacts')]/ancestor::a/following-sibling::button/child::i");
	private By newContactLabel = By.xpath("//span[text()='Create New Contact']");
	private By firstName = By.xpath("//input[@name='first_name']");
	private By lastName = By.xpath("//input[@name='last_name']");
	private By middleName = By.xpath("//input[@name='middle_name']");
	private By description = By.xpath("//textarea[@name='description']");
	private By saveBtn = By.xpath("//button[@class='ui linkedin button']");
	private By profileName = By.xpath("//span[@class='selectable ']");
	
	
	//2. Constructor of the page class
	public ContactsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//3. Page actions: features(behaviour) of the page the form of methods:
	
	
	public boolean newContactLabelDisplayed() {
		
		return driver.findElement(newContactLabel).isDisplayed();
		
	}
	
	public void moveToNewContactsPage()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(contacts)).build().perform();
		driver.findElement(newContact).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fillNewContactForm(String firstname, String lastname, String middlename, String descrptn)
	{
		
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(middleName).sendKeys(middlename);
		driver.findElement(description).sendKeys(descrptn);
		
	}
	
	public void clickOnSaveBtn()
	{
		driver.findElement(saveBtn).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getContactProfileName()
	{
		return driver.findElement(profileName).getText();
	}
	
	
	
	

}
