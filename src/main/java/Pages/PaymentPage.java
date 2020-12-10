package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase
{
	//create constructor
	public PaymentPage(WebDriver driver) 
	{
		super(driver);
	}

	//locate country select drop list
	@FindBy (xpath = "//span[@class='truncate ng-tns-c52-14']")
	WebElement CountryDropList;

	//locate selected country egypt
	@FindBy (xpath = "//div[@title='Egypt']")
	WebElement EgyptSelected;


	//locate address box
	@FindBy (id = "address1")
	WebElement AddressTxtBox;

	//locate city box
	@FindBy (id = "city")
	WebElement CityTxtBox;

	//locate state box
	@FindBy (id = "state")
	WebElement StateTxtBox;

	//locate zip code box
	@FindBy (id = "zip_code")
	WebElement ZipCodeTxtBox;

	//locate card number box
	@FindBy (id = "card_number")
	WebElement CardNumberTxtBox;

	//locate month select drop list
	@FindBy (xpath = "//span[@class='fas fa-caret-down ng-tns-c52-19']")
	WebElement ExpirationDateDropList;
	
	//locate selected month
	@FindBy(xpath = "//div[@title='March']")
	WebElement SelectedMonth;

	//locate year select drop list
	@FindBy (xpath = "//span[@class='truncate ng-tns-c52-20']")
	WebElement YearDateDropList;

	//locate selected year
	@FindBy (xpath = "//div[@title='2022']")
	WebElement SelectedYear;

	//locate security code box
	@FindBy (id = "security_code")
	WebElement SecurityCodeBtxBox;

	//locate Next Button
	@FindBy (xpath = "//button[@class='btn-blue btn-spinner ng-tns-c53-5']")
	WebElement NextBTNBtn;


	public void UserCanWritePaymentInformation( String address , String city , String state , String zipcode , String cardnumber , String securitycode) throws InterruptedException
	{	

		Thread.sleep(3000);
		ClickButton(CountryDropList);
		Thread.sleep(500);		
		ClickButton(EgyptSelected);
		SendTextElementTex(AddressTxtBox, address);
		SendTextElementTex(CityTxtBox, city);
		SendTextElementTex(StateTxtBox, state);
		SendTextElementTex(ZipCodeTxtBox, zipcode);
		SendTextElementTex(CardNumberTxtBox, cardnumber);
		ClickButton(ExpirationDateDropList);
		ClickButton(SelectedMonth);
		ClickButton(YearDateDropList);
		ClickButton(SelectedYear);
		SendTextElementTex(SecurityCodeBtxBox, securitycode);
		ClickButton(NextBTNBtn);
	}
}
