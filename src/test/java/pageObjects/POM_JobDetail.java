/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Config.Common;
import Config.LOCELEMENT;

public class POM_JobDetail {

	Common cmon;
	WebDriver driver;
	
	public POM_JobDetail (WebDriver driver){
		
		this.driver = driver;
		cmon = new Common (driver);
		
	}
	
	private boolean checkPage () {

		
		Actions action= new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		
		cmon.isVisible(By.xpath(LOCELEMENT.BTN_INTERESTED_XPATH));
		cmon.isPresence(By.xpath(LOCELEMENT.BTN_INTERESTED_XPATH)); 
		List <WebElement> elements = driver.findElements(By.xpath(LOCELEMENT.BTN_INTERESTED_XPATH));
		System.out.println("checkPage size :" + (elements.size()));
		if (elements.size() >0)
			return true;
		else
			return false;
		
		
	}
	
	public boolean checkPageExistence (){
		
   
	    
	    boolean result = false;
	    String mwh=driver.getWindowHandle();
	    Set s=driver.getWindowHandles(); //this method will gives you the handles of all opened windows

	    Iterator ite=s.iterator();

	    while(ite.hasNext())
	    {
	        String popupHandle=ite.next().toString();
	        if(!popupHandle.contains(mwh))
	        {
	            driver.switchTo().window(popupHandle);
	            //here you can perform operation in pop-up window**
	            //After finished your operation in pop-up just select the main window again
	            System.out.println("Checking Page");
	            
	        	
	        	try {
	        		Thread.sleep(2000);
	        	} catch (InterruptedException e) {
	        		// TODO Auto-generated catch block
	        		e.printStackTrace();
	        	}
	            
	        	result = checkPage();
	            System.out.println("Checking Page result " + result);
	            driver.switchTo().window(mwh);
	        }
	    }
	    
	    return result;
	}
}
