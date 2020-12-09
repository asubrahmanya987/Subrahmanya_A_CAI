package com.CAI.generic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.model.ITest;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	public ExtentReports reports;
	public ExtentTest etest;
	
	//Creating the Extent report object and starting extent report test
	
	@BeforeClass
	public void startReport()
	{
		reports =	new ExtentReports(extentReport_Path,false);
			
	}
	
	//Launching the browser and maximize the window
	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(String browser) throws MalformedURLException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty(chromekey,chromevalue);
		driver = new ChromeDriver();
		driver.get("https://cai.tools.sap/");
		driver.manage().window().maximize();
		}
		//Docker Setup
//		DesiredCapabilities capabilities=new DesiredCapabilities();
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
//		capabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);	
//		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
//		driver.get("https://cai.tools.sap");
		
	}
	
	//Closing the browser
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		
	}
	
	//End the extent report test
	@AfterClass
	public void  endreport() 
	{
		reports.endTest(etest);
		reports.flush();
	}
}
