
@SmokeTest
Feature: Basic smoke test for career page filtering
  Test high scenarios for SG Digital Careers filtering 



	@Scenario1
	Scenario: Launch career page
		Given I want launch LandingPage
			And I check the Careers menu
		When I click the Careers menu
		Then The Career Page launched
			And I scroll down to see the job result
		
	
	@Scenario2.1
	Scenario: Enter job and see if results come out
		Given I want launch LandingPage
			And I clicked the Careers menu
			And I scroll down to see the job result
		When I look for career "Software Engineer"
		Then I check if there are vacancies
			
				
	@Scenario2.2
	Scenario: Change Location to Singapore and search for "Test Analyst"
		Given I want launch LandingPage
			And I clicked the Careers menu
			And I scroll down to see the job result
		Then I change the location to "Singapore"
			And I look for career "Test Analyst"
		Then I check if there are vacancies
			And I check if the job "Test Analyst" exist and click on it
			And the job detail page should open in new tab
		
	
	@Scenario2.3
	Scenario: Enter special characters '#@' and 'Software Engineer#@' - field should ignore / clear
		Given I want launch LandingPage
			And I clicked the Careers menu
			And I scroll down to see the job result
		When I look for career "#@"
		Then I check if input field is ""
		When I look for career "Software Engineer#@"
		Then I check if the number of vacancies is the same as "Software Engineer"
		

		

		
		