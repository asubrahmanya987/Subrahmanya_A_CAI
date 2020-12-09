package com.CAI.generic;

public interface AutoConstant 
{
	//Initialize driver and excel path
	String chromekey = "webdriver.chrome.driver";
	String chromevalue = System.getProperty("user.dir")+"/driver/chromedriver.exe";;
	String regPospath = System.getProperty("user.dir")+"/Data/Book1.xlsx";
	String regNegPath = System.getProperty("user.dir")+"/Data/Book2.xlsx";
	String screenshot_Path= System.getProperty("user.dir")+"/ScreenShots/test.png";
	String extentReport_Path = System.getProperty("user.dir")+"\\Extentrreport.html";
	
}
