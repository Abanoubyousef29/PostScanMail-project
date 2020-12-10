package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase 
{
	//initialized the WebDriver
	protected WebDriver driver ;
	
	//create constructor
	public PageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	protected static void SendTextElementTex(WebElement TextBox_WE , String TheText)
	{
		TextBox_WE.sendKeys(TheText);
	}
	
	protected static void ClickButton(WebElement Button)
	{
		Button.click();
	}
}
