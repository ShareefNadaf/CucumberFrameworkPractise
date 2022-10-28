package com.cucumber.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.cucumber.driverfactory.DriverFactory;
import com.cucumber.pages.AccountsPage;
import com.cucumber.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsSteps {

	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountPage=new AccountsPage(DriverFactory.getDriver());
	
	@Given("User has already on logged in to application")
	public void user_has_already_on_logged_in_to_application(DataTable credentials) {
		
		List<Map<String,String>> asMaps = credentials.asMaps();
		String username = asMaps.get(0).get("username");
		String password = asMaps.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		loginPage.doLogin(username, password);
		
	}

	@Given("User is on accounts page")
	public void user_is_on_accounts_page() {
		String title = accountPage.getAccountsPageTitle();
		System.out.println("Page title: "+title);
	}

	@Then("User gets accounts section")
	public void user_gets_accounts_section(DataTable expectedaccountList) {
		
		List<String> asList = expectedaccountList.asList();
		System.out.println("Expected List: "+asList);
		List<String> sectionList = accountPage.getAccountSectionList();
		System.out.println("Actual List"+sectionList);
		
		Assert.assertTrue(asList.containsAll(sectionList));
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(int expectedCount) {
		
		Assert.assertEquals(accountPage.getAccountSectionCount(),expectedCount); 
	}

}
