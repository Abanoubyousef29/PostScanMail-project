package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailBoxPage extends PageBase
{
	//create constructor
	public MailBoxPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (linkText = "Inbox")
	WebElement InboxBtn_W;
}
