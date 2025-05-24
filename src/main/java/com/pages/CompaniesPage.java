package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CompaniesPage {
	
	
	private WebDriver driver;
	
	//1. By Locators : OR
	private By name_cmpy = By.xpath("//input[@name='name' and @autocomplete='new-password']");
	private By website_cmpy = By.xpath("//input[@name='url']");
	private By email_cmpy = By.xpath("//input[@placeholder='Email address']");
	private By desctn_cmpy = By.xpath("//textarea[@name='description']");
	private By no_of_emp_cmpy = By.xpath("//input[@name='num_employees']");	
	private By newCompy_title = By.xpath("//span[text()='Create new Company']");
	private By public_access_Btn = By.xpath("//div[@class='four wide field']/button");
	private By private_access_Btn = By.xpath("//button[@class='ui small fluid negative toggle button']");
	private By rigstrd_cmpyName = By.xpath("//span[@class='selectable ']");
	private By userAllowedAccess_drpdwn = By.xpath("//div[contains(text(),'Select users allowed access.')]/following-sibling::i");
	private By user_drpdwn_list = By.xpath("//div[@class='visible menu transition']/descendant::span");
	private By street_address = By.xpath("//input[@name='address']");
	private By city = By.xpath("//input[@name='city']");
	private By state = By.xpath("//input[@name='state']");
	private By pinCode = By.xpath("//input[@name='zip']");
	private By personalEmail = By.xpath("//input[@placeholder='Personal email, Business, Alt...' and @name='name']");
	private By industry = By.xpath("//input[@name='industry']");
	
	
	//2. Constructor of the page class
	public CompaniesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//3. Page actions: features(behaviour) of the page the form of methods:
	
	public String getNewCompyPageTitle()
	{
		return driver.findElement(newCompy_title).getText();
	}
	
	public void companyDetails(String companyName, String website, String email)
	{
		WebElement accessBtn = driver.findElement(public_access_Btn);
		Actions actions = new Actions(driver);
		actions.moveToElement(accessBtn).build().perform();
		
		
		driver.findElement(name_cmpy).sendKeys(companyName);
		driver.findElement(website_cmpy).sendKeys(website);
		driver.findElement(email_cmpy).sendKeys(email);
	}
	
	
	public void companyDetails2(String descp, String no_ofEmps)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100);");
		
		
		driver.findElement(desctn_cmpy).sendKeys(descp);
		driver.findElement(no_of_emp_cmpy).sendKeys(no_ofEmps);
		
		
	}
	
	public String getRegisteredCompanyName()
	{
		return driver.findElement(rigstrd_cmpyName).getText();
	}
	
	public void clickOnPublicAccess()
	{
		driver.findElement(public_access_Btn).click();
		
	}
	
	public String selectPrivateAllowedAcessUser()
	{
		driver.findElement(userAllowedAccess_drpdwn).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement user_drpdwn = driver.findElement(user_drpdwn_list);
		String user = user_drpdwn.getText();
//		System.out.println("Account User :"+user);
		user_drpdwn.click();
		return user;
		
	}
	
	public void enterAddressDetails(String street, String city, String state, String pincode)
	{
		driver.findElement(street_address).sendKeys(street);
		driver.findElement(this.city).sendKeys(city);
		driver.findElement(this.state).sendKeys(state);
		driver.findElement(pinCode).sendKeys(pincode);
		
	}
	
	public void enterEmailandIndustry(String email, String industry)
	{
		driver.findElement(personalEmail).sendKeys(email);
		driver.findElement(this.industry).sendKeys(industry);
	}
	
	
	
	
	

}
