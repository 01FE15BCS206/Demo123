package selenium_testng2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test1 {
	WebDriver driver;
	@BeforeTest
	public void congigurebrowser()
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\training_b6b.01.07\\Desktop\\drivers\\IEDriverServer.exe");
		driver =new InternetExplorerDriver();
		
	}
	@Test
	public void openapplication()
	{
		driver.get("https://www.w3schools.in");
	}
	
	@AfterTest
	public void closeapp()
	{
		driver.close();
	}

}
