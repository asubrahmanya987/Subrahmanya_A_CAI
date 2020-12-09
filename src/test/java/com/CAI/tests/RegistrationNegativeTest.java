package com.CAI.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.CAI.generic.AutoConstant;
import com.CAI.generic.BaseTest;
import com.CAI.generic.ExcelData;
import com.CAI.generic.ListenerTest;
import com.CAI.pages.RegistrationPage;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(ListenerTest.class)
public class RegistrationNegativeTest extends BaseTest implements AutoConstant
{
	String exp="Thank you for registering with SAP Conversational AI" ;
	
	//Method used to verify the Registration feature by entering Invalid values
	@Test(dataProvider="regdatanegative")
	public void registrationNegativeTest(String fn,String ln,String email,String pwd,String repwd) throws InterruptedException
	{
		
		try
		{
			
			//RegistrationPage rp = new RegistrationPage(driver);
			
			RegistrationPage rp=new RegistrationPage(driver);
			etest = reports.startTest("RegistrationNegativeTest");
			rp.Registrationclick();
			etest.log(LogStatus.PASS, "Clicked Sigh up button");
			rp.EnterFirstname(fn);
			etest.log(LogStatus.PASS, "Entered First name");
			rp.EnterLastname(ln);
			etest.log(LogStatus.PASS, "Entered Last name");
			rp.EnterEmail(email);
			etest.log(LogStatus.PASS, "Entered Email");
			rp.EnterPassword(pwd);
			etest.log(LogStatus.PASS, "Enetered Password");
			rp.ConfirmPassword(repwd);
			etest.log(LogStatus.PASS, "Renetered password");
			rp.ClickPrivacy();
			etest.log(LogStatus.PASS, "Clicked Privacy");
			rp.Clickterms();
			etest.log(LogStatus.PASS, "Clicked terms");
			rp.ClickRegister();	
			etest.log(LogStatus.PASS, "Clicked Register");
			rp.assertRegStatus(exp);
			etest.log(LogStatus.PASS, "Registered successfully");
			
		}
		catch(Exception e)
		{
			etest.log(LogStatus.FAIL, e.getMessage());
		}

			
	}
		//This method allows us to pass the multiple values to a single test in single execution using TestNG Data-provider annotation
		@DataProvider(name="regdatanegative")
		public String[][] getRegData() throws Exception
		{
			int rs=ExcelData.getRowSize(regNegPath,"sheet1");
			int cs = ExcelData.columnSize(regNegPath, 1,"sheet1");
			System.out.println(rs+"\n"+cs);
			
			
			String[][] reg=new String[rs][cs];
			
			for(int i=1;i<=rs;i++)
			{
				for(int j=0;j<cs;j++)
				{
				reg[i-1][j]=ExcelData.getData(regNegPath, i, j,"sheet1");
				}
			}
			return reg;
			
		}
	

}
