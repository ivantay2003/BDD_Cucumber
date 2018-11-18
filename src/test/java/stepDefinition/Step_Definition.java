/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.POM_Manager;
import cucumber.api.java.en.Then;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;



public class Step_Definition extends POM_Manager{
	//https://medium.com/@mvwi/story-writing-with-gherkin-and-cucumber-1878124c284c
	
	@Before
	public void setup(){
		
		POM_Manager.setInitializePageObjects();
		
	}
	
	@After
	public void close(){
		
		closeBrowser();
	}
	

	
  @Given("^I want launch LandingPage$")
  public void given() throws Throwable {
	  
	  this.launchLandingPage();
  }

  @And("^I check the Careers menu$")
  public void checkCareersMenu() throws Throwable {
	  assertTrue (pom_Home.getMenuText().get(7).contains("Careers"));  //7 is the menu "Careers"
  }
  

  
  @When("^I click the Careers menu$")
  public void clickCareerMenu() throws Throwable {
	
		pom_Home.menuCareers();//Click on Careers menu
  }
  
  @And("^I clicked the Careers menu$")
  public void clickCareerMenuAnd() throws Throwable {
	
	  clickCareerMenu();
  }
  
  @Then("^The Career Page launched$")
  public void checkCareersPageExist() throws Throwable {
	  //Career Page Exits
		assertTrue(pom_Career.checkIfIsCareerPage(), "User 1 Acceptance Criteria 1.3 - Career page exist "); //Career Page must exist - true
		
  }

  @And("^I scroll down to see the job result$")
  public void scrollDownPage() throws Throwable {
	  
	  cmon.scrollDown(config.getScrollPixel()); //Scroll down page
  }

  @Then("^I change the location to \"([^\"]*)\"$")
  public void changeLocation(String country) throws Throwable {
	  
	  System.out.println("Country :" + country);
	  pom_Career.selectLocation(country);
  }

  @When("^I look for career \"([^\"]*)\"$")
  public void inputJob(String job) throws Throwable {
	
		//Input vacancies - Software Engineer
		pom_Career.inputSearchVacancies(job);
		
  }
  
  @Then("^I check if there are vacancies$")
  public void checkVacancies() throws Throwable {
	//Check if there vacancies 
	  //System.out.println("assertTrue ((pom_Career.checkVacancies().size() : " + pom_Career.checkVacancies().size());
	  assertTrue ((pom_Career.checkVacancies().size())>1,"User 2 Acceptance Criteria 2.1 / 2.3. Able to enter in field and results displayed"); //More than 0 means there is job vacancies
	 
  }
  
  @And("^I check if the job \"([^\"]*)\" exist and click on it$")
  public void searchJobInTable(String job) throws Throwable {
	//Find if job exist "Test Analyst"
	  assertNotNull(pom_Career.searchJobInTable(job), "User 2 Acceptance Criteria 2.3 - Display result ");
	 
  }
  
  @And("^the job detail page should open in new tab$")
  public void detectNewJobDetailPage() throws Throwable {
	
	//Check if page exist
	  assertTrue(pom_Details.checkPageExistence(), "Check job detail page for selected vacancies");

	 
  }
  
  
  @Then("^I check if input field is \"([^\"]*)\"$")
  public void checkCheckIfInputField(String text) throws Throwable {
	
	  Assert.assertEquals (pom_Career.getInputFieldText(),text, "User 2 Acceptance Criteria 2.2  - Special character should be cleared according to Acceptance Criteria 2");
		
  }
  
  
  @Then("^I check if the number of vacancies is the same as \"([^\"]*)\"$")
  public void checkNoChangeInFilter(String job) throws Throwable {

	  
		int initialSize = pom_Career.checkVacancies().size(); //Get initial row size for job
		pom_Career.inputSearchVacancies(job);
		int changeSize = pom_Career.checkVacancies().size(); //Get row size for change size of job
		Assert.assertEquals (initialSize,changeSize, "User 2 Acceptance Criteria 2.2  - Special character should be ignored according to Acceptance Criteria 2");
  }
  
    
  


}
