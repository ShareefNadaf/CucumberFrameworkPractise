Feature: Login page feature

  Scenario: Login page title
    Given User is on login page
		When User gets the title of page
		Then page title should be "Login - My Store"

	Scenario: Login with correct credentials
		Given User is on login page
		When User enters username "myhello@gmail.com"
		And User enters password "hello@123"
		And User clicks on login button
		Then User gets the title of page
		And page title should be "My account - My Store"
