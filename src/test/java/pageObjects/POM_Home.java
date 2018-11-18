/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Config.Common;

import Config.LOCELEMENT;


public class POM_Home {
	Common cmon;
	WebDriver driver;
	
	public POM_Home (WebDriver driver){
		
		this.driver = driver;
		cmon = new Common (driver);
		
	}
	
	public void menuCareers(){
		
		  cmon.isVisible (By.xpath(LOCELEMENT.CAREER_XPATH));
		  cmon.isPresence(By.xpath(LOCELEMENT.CAREER_XPATH));
		  driver.findElement(By.xpath(LOCELEMENT.CAREER_XPATH)).click();
	}
	
	public List <String>  getMenuText () {
		
		String str = "//ul[@id='menu-main-menu-1']//li";
		List <WebElement> elements = driver.findElements(By.xpath(str));
		List <String> returnString = new ArrayList <> ();
		
		for (WebElement elem : elements){
			
			String text = elem.getText();
			//System.out.println(text);
			returnString.add(text);
			
		}
		
		return returnString;
				
	}

}
