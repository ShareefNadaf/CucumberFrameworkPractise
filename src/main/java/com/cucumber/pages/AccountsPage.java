package com.cucumber.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By accountSections=By.xpath("//div[@class='row addresses-lists']/child::div/ul/li");
	
	 public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	 
	 public String getAccountsPageTitle()
	 {
		 return driver.getTitle();
	 }
	 
	 public int getAccountSectionCount()
	 {
		return driver.findElements(accountSections).size();
	 }
	 
	 public List<String> getAccountSectionList()
	 {
		 List<String> actualList=new ArrayList<String>();
		 
		 List<WebElement> list = driver.findElements(accountSections);
		 for(WebElement st: list)
		 {
			 String text = st.getText();
			 System.out.println(text);
			 actualList.add(text);
		 }
		 return actualList;
	 }
}
