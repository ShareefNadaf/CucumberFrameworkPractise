package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.driverfactory.DriverFactory;

public class LoginPage {

	private WebDriver driver;
	
	//Locators
	private By emailID= By.id("email");
	private By password=By.id("passwd");
	private By loginButton=By.id("SubmitLogin");
	
	//Initialize driver variable
	 public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//actions of page
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUsername(String email)
	{
		driver.findElement(emailID).sendKeys(email);
		
	}
	
	public void enterPassword(String passowrd)
	{
		driver.findElement(password).sendKeys(passowrd);
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public AccountsPage doLogin(String user, String pass)
	{
		driver.findElement(emailID).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
		return new AccountsPage(DriverFactory.getDriver());
	}
}
