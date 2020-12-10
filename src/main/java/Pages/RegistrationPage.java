package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase
{

	//create constructor
	public RegistrationPage(WebDriver driver) 
	{
		super(driver);
	}

	//Find elements in registration page
	//locate first name box
	@FindBy (id = "first_name")
	WebElement FirstNameTxtBox;

	//locate last name box
	@FindBy (id = "last_name")
	WebElement LastNameTxtBox;

	//locate Email box
	@FindBy (id = "email")
	WebElement EmailAddressTxtBox;

	//locate Phone number box
	@FindBy (id = "phone")
	WebElement PhoneNumberTxtBox;

	//locate Password box
	@FindBy (id = "password")
	WebElement PasswordTxtBox;

	//locate confirm Password box
	@FindBy (id = "confirm_password")
	WebElement ConfirmPasswordTxtBox;

	//locate company name box
	@FindBy (id = "business_name")
	WebElement CompanyTxtBox;

	//locate change plan button or done button
	@FindBy(xpath = "//span[@class='plans-expander ng-tns-c50-4']")
	WebElement ChangePlanBtnorDoneBtn;

	//locate premium plan button
	@FindBy (xpath = "/html/body/app-root/div/div/app-registration/div[2]/div[1]/div[2]/div[1]/app-create-account/form/div[1]/div[5]/div[3]/div[2]/div[1]")
	WebElement PremiumMailBoxBtn;

	//locate Accept Terms Check mark 
	@FindBy (xpath = "//i[@class='ng-tns-c50-4']")
	WebElement AcceptTermsConditionsCheckBoxCheckMark;

	//locate Next Button
	@FindBy (xpath = "//button[@class='btn-blue btn-spinner ng-tns-c50-4']")
	WebElement NextBTNBtn;



	//Find elements in final page 
	//locate  Successful Msg
	@FindBy (xpath = "//h2[@class='ng-tns-c54-6']")
	public WebElement SuccessfulRegistrationMSGTxt;

	//locate  Go to mail box button
	@FindBy (xpath = "//button[@class='btn-blue ng-tns-c54-6']")
	WebElement TakeMailBoxBTNBtn;
	
	//locate  Inbox button
	@FindBy(xpath = "//a[@class='ng-tns-c90-35 active']")
	public WebElement InboxBtn;
	
	// locate the more information three dots 
	@FindBy(xpath = "//span[@class='truncate']")
	public WebElement MoreInfoBtn;
	
	// locate log out button
	@FindBy(xpath = "//button[@class='btn-blue']")
	public WebElement LogOutBtn;


	//Method that fill information of the first step at the registration 
	public void UserCanWritePersonalInformation(String firstName , String lastName , String Email , String phoneNumber , String password , String companyName) throws InterruptedException
	{
		SendTextElementTex(FirstNameTxtBox, firstName);
		SendTextElementTex(LastNameTxtBox, lastName);
		SendTextElementTex(EmailAddressTxtBox, Email);
		SendTextElementTex(PhoneNumberTxtBox, phoneNumber);
		SendTextElementTex(PasswordTxtBox, password);
		SendTextElementTex(ConfirmPasswordTxtBox, password);
		SendTextElementTex(CompanyTxtBox, companyName);
		ClickButton(ChangePlanBtnorDoneBtn);
		ClickButton(PremiumMailBoxBtn);
		ClickButton(ChangePlanBtnorDoneBtn);
		ClickButton(AcceptTermsConditionsCheckBoxCheckMark);
		ClickButton(NextBTNBtn);
	}

	public void UserCanLogOut()
	{
		ClickButton(MoreInfoBtn);
		ClickButton(LogOutBtn);
	}
	
	public void OpenMailBoxPageFromDonePage()
	{
		ClickButton(TakeMailBoxBTNBtn);
	}

}
