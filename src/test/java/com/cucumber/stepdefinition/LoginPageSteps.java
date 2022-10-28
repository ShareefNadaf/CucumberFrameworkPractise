package com.cucumber.stepdefinition;

import org.junit.Assert;
import com.cucumber.driverfactory.DriverFactory;
import com.cucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {

	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private static String pageTitle;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("User gets the title of page")
	public void user_gets_the_title_of_page() {
		pageTitle = loginPage.getPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedCondition) {
		
		Assert.assertEquals(pageTitle,expectedCondition);
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
	  loginPage.enterUsername(username);
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
	    loginPage.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	 loginPage.clickOnLoginButton();
	}
}
