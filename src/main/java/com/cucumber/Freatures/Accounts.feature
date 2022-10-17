Feature: Account page features

	Background:
		Given User has already on logged in to application
		|username|password|
		|myhello@gmail.com|hello@123|
	
  Scenario: Accounts page title
    Given User is on accounts page
    When User gets the title of page
    Then page title should be "My account - My Store"

  Scenario: Accounts section count
    Given User is on accounts page
    Then User gets accounts section
    |ORDER HISTORY AND DETAILS|
    |MY CREDIT SLIPS|
    |MY ADDRESSES|
    |MY PERSONAL INFORMATION|
    |MY WISHLISTS|
    And Account section count should be 5