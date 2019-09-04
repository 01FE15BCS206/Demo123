package selenium_testng2;


import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firefox_selenium {

	FirefoxDriver driver;
	@BeforeTest
	public void openfirefox()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\suma.uddan\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
	}
	
	@Test
	public void openapplication()
	{
		driver.get("https://www.w3schools.in/");
	}
	@AfterTest
	public void closeapp()
	{
		driver.close();
	}
}
