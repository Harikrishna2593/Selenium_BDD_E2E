package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	
	private By homeMenuList = By.xpath("//div[@id='main-nav']/div");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
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
	
	
}
