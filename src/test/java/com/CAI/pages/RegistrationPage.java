package com.CAI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.CAI.generic.GenericUtils;




public class RegistrationPage 
{
	//Initialize the webelements using @FindBy annotation
	public WebDriver ldriver;
	@FindBy(xpath="//h1[contains(@id,'ids-heading-1')]")
	private WebElement regwindow;
	@FindBy(xpath="//div[text()='OK']")
	private WebElement ok; 
	@FindBy(xpath="//div[text()='Sign up']")
	private WebElement signup;
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement firstname;
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastname;
	@FindBy(xpath="//input[@name='mail']")
	private WebElement email;
	@FindBy(xpath="//input[@id='newPasswordInput']")
	private WebElement password;
	@FindBy(xpath="//input[@id='retypeNewPasswordInput']")
	private WebElement reenterpassword;
	@FindBy(xpath="//input[@id='pdAccept']")
	private WebElement privacystatement;
	@FindBy(xpath="//input[@id='touAccept']")
	private WebElement termsconditions;
	@FindBy(xpath="//button[@id='sapStoreRegisterFormSubmit']")
	private WebElement register;
	@FindBy(xpath="//h1[text()='Thank you for registering with SAP Conversational AI']")
	private WebElement regstatus;
	
	
	//Creating the object repository by calling the pagefactory.init element method
	public RegistrationPage(WebDriver driver)
	{
		this.ldriver=driver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	//Clicking the cookie banner and sigh up button
	public void Registrationclick() throws InterruptedException
	{
		ok.click();
		signup.click();		
		GenericUtils.switchToFrame(ldriver, "IDS_UI_Window", 60);	
	
	}
	
	//set the Firstname value
	public void EnterFirstname(String fname)
	{
		GenericUtils.explcitWait(ldriver, regwindow, "visibility", 60);
		firstname.sendKeys(fname);	
	}
	//set the last name value
	public void EnterLastname(String lname)
	{
		lastname.sendKeys(lname);
		
	}
	//set the email
	public void EnterEmail(String Email) 
	{
		email.sendKeys(Email);
	}
	public void EnterPassword(String Pwd) 
	{
		password.sendKeys(Pwd);
	}
	//set the password
	public void ConfirmPassword(String Cpwd)
	{
		reenterpassword.sendKeys(Cpwd);
	
	}
	//clicked privacy button
	public void ClickPrivacy()
	{
		privacystatement.click();
	}
	//clicked terms and conditions button
	public void Clickterms()
	{
		termsconditions.click();
		
	}
	//clicked Register button
	public void ClickRegister() 
	{
		register.click();
		
	}
	//Validating the Registration confirmation message
	public  void assertRegStatus(String expected) throws InterruptedException 
	{
		GenericUtils.explcitWait(ldriver, regstatus, "vis", 60);
		String actual = regstatus.getText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
	}
}
	
