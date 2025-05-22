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
	private By access_Btn = By.xpath("//button[@class='ui small fluid positive toggle button']");
	private By rigstrd_cmpyName = By.xpath("//span[@class='selectable ']");
	
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
		WebElement accessBtn = driver.findElement(access_Btn);
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
	
	
	
	
	
	

}
