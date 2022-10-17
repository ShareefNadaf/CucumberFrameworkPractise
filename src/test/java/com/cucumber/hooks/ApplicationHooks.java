package com.cucumber.hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.cucumber.driverfactory.DriverFactory;
import com.cucumber.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader cofigReader;
	private Properties prop;
	
	@Before(order=0)
	public void getProperty() 
	{
		cofigReader=new ConfigReader();
		prop=cofigReader.intiProp();
	}
	
	@Before(order=1)
	public void launchBrowser()
	{
		String browser = prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver = driverFactory.initDriver(browser);
	}
	
	@After(order=1)
	public void takeScreenshot(Scenario sc)
	{
		if(sc.isFailed())
		{
			String scenarioName = sc.getName().replaceAll(" ", "_");
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", scenarioName);
		}
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
}
