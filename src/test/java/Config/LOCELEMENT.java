/*
 *  Copyright (C) 2018 Ivan Tay - All Rights Reserved
 */

package Config;

public class LOCELEMENT {
	
	//Landing Page
	//public static String CAREER_XPATH = "//li/a[contains(text(),'Careers')]";
	public static String CAREER_XPATH = "//ul[@id='menu-main-menu-1']//li[8]";
	//public static String CAREER_XPATH ="//a[contains(@href, 'https://www.sgdigital.com/careers')]";
	//public static String CAREER_XPATH = "//ul[@id='menu-main-menu-1']//li[contains(@class,'menu-item menu-item-type-post_type menu-item-object-page menu-item-825')]";
			//contains(text(), 'Submit')]
	
	
	//Career Pgge
	public static String CHECKTEXT_XPATH = "//p[contains(text(),'We are known globally for creating innovative, ent')]";
	
	public static String TABLE_XPATH = "//table[@class='srJobList']//tbody";
	public static String TABLE_ROWS_XPATH = "//tbody/tr";
	
	public static String INPUT_FILTER_ALL_XPATH = "//div[@id='facet_location']//ul[@class='srSearchOptionList']";
	public static String INPUT_XPATH="//input[@class='srSearchInput']";
	public static String INPUT_FILTER_SINGAPORE_XPATH = "//div[@id='facet_location']//ul[@class='srSearchOptionList']//li[2]";
	public static String INPUTCAREERTEXT_XPATH ="//input[@value='Filter by title, expertise']";
	public static String TABLE_LOCATION_XPATH = "//span[contains(text(),'Location')]";

	public static String TABLE_LOCATION_VIEWALL_XPATH = "//span[contains(text(),'View all')]";
	public static String TABLE_LOCATION_SINGAPORE_XPATH ="//span[contains(text(),'Singapore')]";
	public static String TABLE_FIRST_ROW_XPATH = "//tbody//tr[2]//td[1]";
	
	public static String SPAN_SINGAPORE_XPATH = "//span[contains(text(),'Singapore')]";
	public static String SPAN_SINGAPORE_LOC_XPATH = "//span[@class='srSearchOptionText'][contains(text(),'Singapore')]";
	public static String LANDINGPAGE = "https://www.sgdigital.com/";
	
	//Job Detail
	public static String BTN_INTERESTED_XPATH ="//button[@id='st-apply']";

}
