package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); //helpfull in parallel execution
	
	/**
	 * This method is used to initialize the ThreadLocal driver based on the given browser.
	 *
	 * @param browser the name of the browser to initialize the driver for
	 * @return this will return the ThreadLocal driver instance
	 */

	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} 
		else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} 
		else if (browser.equals("safari")) {
			
			tlDriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser value: "+ browser);
		}
		
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	
	/**
	 * This method is used to retrieve the driver instance from ThreadLocal.
	 *
	 * @return the WebDriver instance from ThreadLocal
	 */

	
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}
}
