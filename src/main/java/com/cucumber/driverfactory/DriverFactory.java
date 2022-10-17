package com.cucumber.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			threadLocal.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			threadLocal.set(new EdgeDriver());
		}
		else
		{
			System.out.println( browser+ "is not a valid browser.Please enter a valid browser");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return threadLocal.get();
	}
	
}
