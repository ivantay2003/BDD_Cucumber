/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package SGDigitalTest;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.POM_Manager;
public class Test_POM_Location extends POM_Manager {
	


	

	
	@BeforeTest
	public void setup(){
		

		POM_Manager.setInitializePageObjects();

		

		
	}
	
	@AfterTest
	public void close(){

		closeBrowser();
	}
	
  @Test
  public void start() {
	  
	  
	  
	  //Landing Page
	  launchLandingPage();
	  
	  //Click on Careers menu
	  pom_Home.menuCareers();
	  
	  //Scroll down till see table
	  cmon.scrollDown(config.getScrollPixel());
	
	  //Select Singapore
	  pom_Career.selectLocation("Singapore");
	  
	  //Check if there vacancies 
	  assertTrue ((pom_Career.checkVacancies().size())>0,"User 2 Acceptance Criteria 2.1 / 2.3. Able to enter in field and results displayed"); //More than 0 means there is job vacancies
	  
	  //Find if job exist "Test Analyst"
	  assertNotNull(pom_Career.searchJobInTable("Test Analyst"), "User 2 Acceptance Criteria 2.3 - Display result ");
	
	  //Check if page exist
	  assertTrue(pom_Details.checkPageExistence(), "Check job detail page for selected vacancies");

	 
  }
}
