package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	private WebDriver driver;
	
	//1. By Locators : OR
	private By homeMenuList = By.xpath("//div[@id='main-nav']/div");
	private By accountName = By.xpath("//b[contains(text(),'Photon')]");
	private By accountUserName = By.xpath("//span[contains(text(),'Har Kris')]");
	private By companies = By.xpath("//span[contains(text(),'Companies')]");
	private By new_Company = By.xpath("//span[contains(text(),'Companies')]/ancestor::a/following-sibling::button/child::i");
	
	
	//2. Constructor of the page class
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//3. Page actions: features(behaviour) of the page the form of methods:
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public int getHomeMenuListCount()
	{
		return driver.findElements(homeMenuList).size();
	}
	
	public List<String> getHomeMenuList()
	{
		List<String> h_MenuList = new ArrayList<String>();
		List<WebElement> menuList = driver.findElements(homeMenuList);
		
		for(WebElement e : menuList)
		{
			String menuName = e.getText();
			System.out.println(menuName);
			h_MenuList.add(menuName);
		}
		
		return h_MenuList;
	}
	
	public String getAccountName()
	{
		return driver.findElement(accountName).getText();
	}
	
	public String getAccountUserName()
	{
		return driver.findElement(accountUserName).getText();
	}
	
	public CompaniesPage clickOnNewCompanyBtn()
	{
		WebElement compnies = driver.findElement(companies);
		WebElement new_compy = driver.findElement(new_Company);
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(compnies).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new_compy.click();

		return new CompaniesPage(driver);
	
	}
	
	
}
