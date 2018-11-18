/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package SGDigitalTest;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.POM_Manager;

public class Test_POM_ValidationInput extends POM_Manager{
  

	
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

	//Check that the career is in the menu
	assertTrue (pom_Home.getMenuText().get(7).contains("Careers"));  //7 is the menu "Careers"
	
	//Click on Careers menu
	pom_Home.menuCareers();
	
	//Career Page
	assertTrue(pom_Career.checkIfIsCareerPage(), "User 1 Acceptance Criteria 1.1 / 1.2- 'Careers' in menu"); //Career Page must exist - true
	
	//Scroll down till see table
	cmon.scrollDown(config.getScrollPixel());
	
	//Input vacancies - Software Engineer
	pom_Career.inputSearchVacancies("Software Engineer");
	Assert.assertEquals (pom_Career.getInputFieldText(),"Software Engineer", "User 2 Acceptance Criteria 2.1 / 2.2  -Can input and input field should show 'Software Engineer'");
	
	//Check if there vacancies 
	assertTrue ((pom_Career.checkVacancies().size())>0, "User 2 Acceptance Criteria 2.3  - Results should display more than 0 vacancies"); //More than 0 means there is job vacancies
	
	//Clear the input field
	pom_Career.inputSearchVacancies("");
	
	
	/*
	 *  Below test cases fail for Acceptance criteria 2. With special characters input, the filter did not ignore or clear (FAIL).
	 */
	
	//test Input with special characters '#@' - should clear the input if special characters
	pom_Career.inputSearchVacancies("#@");
	Assert.assertEquals (pom_Career.getInputFieldText(),"", "User 2 Acceptance Criteria 2.2  - Special character should be cleared according to Acceptance Criteria 2");
	
	//test Input with special characters - should ignore. The result should still be the same if i input 'Software Engineer' and 'Software Engineer#'
	pom_Career.inputSearchVacancies("Software Engineer");
	int initialSize = pom_Career.checkVacancies().size(); //Get row size for "Software Engineer"
	pom_Career.inputSearchVacancies("Software Engineer#");
	int changeSize = pom_Career.checkVacancies().size(); //Get row size for "Software Engineer#"
	Assert.assertEquals (initialSize,changeSize, "User 2 Acceptance Criteria 2.2  - Special character should be ignored according to Acceptance Criteria 2");
	
  }
}
