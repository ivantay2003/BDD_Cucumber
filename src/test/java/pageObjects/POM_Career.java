/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Config.LOCELEMENT;

import Config.Common;

public class POM_Career {
	Common cmon;
	WebDriver driver;
	
	public POM_Career (WebDriver driver){
		
		this.driver = driver;
		cmon = new Common (driver);
		
	}
	
	public boolean checkIfIsCareerPage(){
		
		List <WebElement> elements = driver.findElements(By.xpath(LOCELEMENT.CHECKTEXT_XPATH));
		
		if (elements.size()> 0)
			return true;
		else 
			return false;
					
	}
	
	public void inputSearchVacancies (String text) {
		

	  cmon.isPresence(By.xpath(LOCELEMENT.INPUT_XPATH));
	  driver.findElement(By.xpath(LOCELEMENT.INPUT_XPATH)).clear();	  
	  driver.findElement(By.xpath(LOCELEMENT.INPUT_XPATH)).sendKeys(text);
	  driver.findElement(By.xpath(LOCELEMENT.INPUT_XPATH)).sendKeys(Keys.ENTER);
	}
	
	public List <String> checkVacancies (){
		
		
			
	  List <String> resultString =  new ArrayList <> ();
		  
	  List<WebElement> tableRows = driver.findElements(By.xpath(LOCELEMENT.TABLE_ROWS_XPATH));
	  cmon.isPresence(By.tagName("tr"));
	  cmon.isVisible (By.tagName("tr"));
	  //int size = tableRows.size();
	  //System.out.println("Rows of table :" + size);
	  int i = 0;
	  try {
		  for (WebElement element : tableRows){
			  
			  String str = element.getText();
			  resultString.add(str);
			  //System.out.println(i + " : " + str);
			  i++;
			  
					  
		  }
	  }catch(StaleElementReferenceException e) {
		  
		  System.out.println("Error : " + e.getMessage());
	  }
	  
	  return resultString;
		
	}
	
	public boolean compareNewOldSize (String newText, int initialSize){
		
	
		this.inputSearchVacancies(newText); //size should still be the same
		int newSize = this.checkVacancies().size();
		
//		System.out.println("initialSize : " + initialSize);
//		System.out.println("newSize : " + newSize);
		
		if (newSize != initialSize) {
			
			return false;
			
		}else 
			return true;
	}
	
	public void selectLocation (String country){
		
		String xpath1 = "//span[contains(text(),'";
		String xpath2 = "')]";
		String xpath = xpath1 + country + xpath2;
		
		System.out.println("xpath in selectLocation : " + xpath);
		
		driver.findElement(By.xpath(LOCELEMENT.TABLE_LOCATION_XPATH)).click();
		//driver.findElement(By.xpath(LOCELEMENT.INPUT_FILTER_ALL_XPATH)).click();
		//"//span[contains(text(),'Singapore')]"

	  cmon.isPresence(By.xpath(xpath));
	  cmon.isVisible(By.xpath(xpath));
	  driver.findElement(By.xpath(xpath)).click();
	}
	
	public WebElement searchJobInTable (String job){
		
		WebElement element = null;
		////td[contains(text(),'Software Engineer L2')]
		String xpath1 = "//td[contains(text(),'";
		String xpath2 = "')]";
		String xpath = xpath1 + job + xpath2;
		System.out.println("xpath in searchJobInTable : " + xpath );
		
		try {
			
			cmon.isPresence(By.xpath(xpath)); 
			element = driver.findElement(By.xpath(xpath));
			element.click();
		}catch (TimeoutException e){
			
			element = null;
			System.out.println(e.getMessage());
		}
		
		
		return element;
		
		
	}
	
	public String getInputFieldText (){
		
		String str = driver.findElement(By.xpath(LOCELEMENT.INPUT_XPATH)).getAttribute("value");
		
		
		return str;
	}
	
}
