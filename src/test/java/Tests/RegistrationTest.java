package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.PaymentPage;
import Pages.RegistrationPage;

public class RegistrationTest extends TestBase
{
	// create an object from RegistrationPage class
	RegistrationPage RegistrationObject;
	
	// create an object from PaymentPage class
	PaymentPage PaymentPageObject;

	//Provide Data From Excel Annotation 
	@DataProvider(name="Data")
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		
		return ER.GetExcelData ();
	}


	@Test (priority=1,alwaysRun=true,dataProvider="Data")
	public void UserCanRegisterSuccessfully(String Email , String Password ) throws InterruptedException
	{		
		RegistrationObject = new RegistrationPage(driver);
		// call the function which will fill the personal information
		Thread.sleep(2000);
		RegistrationObject.UserCanWritePersonalInformation("Abanoub", "Yousef", Email , "5758848" , Password , "Automation");
		
		Thread.sleep(3000);
		PaymentPageObject = new PaymentPage(driver);
		// call the function which will call the payment information
		PaymentPageObject.UserCanWritePaymentInformation("330MostafaKamelStr", "Alex", "Alex", "1564", "4111111111111111" , "123");
			
		Thread.sleep(2000);
		RegistrationObject = new RegistrationPage(driver);
		//call function that will open the mail box page
		RegistrationObject.OpenMailBoxPageFromDonePage();
		
		Thread.sleep(2000);
		try 
		{
			//to make sure that loaded the mail box page
			Assert.assertTrue(RegistrationObject.InboxBtn.getText().contains("Inbox"));
			System.out.println("moved to mail box successfully");
		} 
		catch (Exception e) 
		{
			//in case there is an error 
			System.out.println("Error occurred  " + e.getMessage());
		}
		
		Thread.sleep(2000);
		//call the function that will log out
		RegistrationObject.UserCanLogOut();
		
		Thread.sleep(2000);
		// go home to the Register page
		driver.navigate().to("https://app-dev.postscanmail.com/registration?plan=4241&store=6&address=1004");

	}



}
