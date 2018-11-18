/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package pageObjects;

import org.openqa.selenium.WebDriver;

import Config.Common;
import Config.Configuration;
import Config.LOCELEMENT;

public class POM_Manager {

	
	public static Common cmon ;
	private static WebDriver driver ;
	public static Configuration config = new Configuration();
	
	public static POM_Home pom_Home ;
	public static POM_Career pom_Career ;
	public static POM_JobDetail pom_Details;
	
	public static void setInitializePageObjects (){
		
		driver = config.getWebDriver();
		cmon = new Common (driver);
		
		pom_Home = new POM_Home(driver);
		pom_Career = new POM_Career (driver);
		pom_Details = new POM_JobDetail (driver);
		
		
	}
	
	public void launchLandingPage(){
		/*
		 * Landing page URL
		 */
		driver.get(LOCELEMENT.LANDINGPAGE);
		
	}
	
	public void closeBrowser () {
		
		driver.quit();
	}
	
	public void scrollDown () {
		/*
		 * Scroll down the page
		 */
		
		cmon.scrollDown();
	}
	
	public void scrollDown (int pixels) {
		/*
		 * Scroll down the page
		 */
		
		cmon.scrollDown(pixels);
	}
	
}
