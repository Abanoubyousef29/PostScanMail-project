package Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.Helper;
//import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.ResubmissionStrategy.Enabled;

public class TestBase 
{
	public static WebDriver driver;

	@BeforeClass
	@Parameters({"browser"})
	//by defult will choose chrome
	public void OpenDriver(@Optional("chrome") String BrowserName)
	{

		if (BrowserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		//to change the driver defult use firefox while calling the driver 
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		//maximize the window
		driver.manage().window().maximize() ;

		//wait for loading
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.navigate().to("https://app-dev.postscanmail.com/registration?plan=4241&store=6&address=1004");
	}

	@AfterClass
	public void StopDriver()
	{
		driver.quit();
	}

	//take screenshot in failure
	@AfterMethod
	public void TakeScreenShotOnFailur(ITestResult Result) throws IOException
	{
		if(Result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking ScreenShot......");
			Helper.captureScreenshot(driver, Result.getName() );
		}
	}
}
