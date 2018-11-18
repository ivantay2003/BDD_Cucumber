/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package SGDigitalTest;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.POM_Manager;

public class Test_POM_Basic extends POM_Manager{
  

	
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
	assertTrue (pom_Home.getMenuText().get(7).contains("Careers"), "User 1 Acceptance Criteria 1.1 / 1.2- 'Careers' in menu");  //7 is the menu "Careers"
	
	//Click on Careers menu
	pom_Home.menuCareers();
	
	//Career Page
	assertTrue(pom_Career.checkIfIsCareerPage(), "User 1 Acceptance Criteria 1.3 - Career page exist "); //Career Page must exist - true
	
	//Scroll down till see table
	cmon.scrollDown(config.getScrollPixel());
	
	//Input vacancies - Software Engineer
	pom_Career.inputSearchVacancies("Software Engineer");
	
	//Check if there vacancies 
	assertTrue ((pom_Career.checkVacancies().size())>0, "User Acceptance Criteria 2.3 - Result should display"); //More than 0 means there is job vacancies
	


	
  }
}
