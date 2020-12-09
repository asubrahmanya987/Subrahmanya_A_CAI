package com.CAI.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils
{

	//Method used to switch to the frame by using ID
	public static void switchToFrame(WebDriver ldriver,String id,int time) 
	{	

		WebDriverWait wait=new WebDriverWait(ldriver, time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}
	
	//Method used to tell the webdriver to wait for a certain conditions.
	public static void explcitWait(WebDriver ldriver,WebElement ele, String action,int time )
	{
		WebDriverWait wait=new WebDriverWait(ldriver, time);
		if(action.equals("clickable"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		else if(action.equals("visibility"))
		{
		
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(@id,'ids-heading-1')]")));
			
		}
		else if(action.equals("vis"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Thank you for registering with SAP Conversational AI']")));
		}
		
	}

}
