package selenium_testng2;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class driver1 {
	WebDriver driver;
	@BeforeTest
	public void  chromedriver1()
	{
		driver=Driver.configuredriver("chrome");
	}
	@Test
	public void openapplication()
	{
		driver.get("http://10.232.237.143:443/TestMeApp");
	}
	@AfterTest
	public void closeapp()
	{
		driver.close();
	}
	
}
