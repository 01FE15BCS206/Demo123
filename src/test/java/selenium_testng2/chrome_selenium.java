package selenium_testng2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chrome_selenium {
	WebDriver driver;
	@BeforeTest
	public void  chromedriver1()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suma.uddan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
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
