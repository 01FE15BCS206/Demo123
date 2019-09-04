package selenium_testng2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sel_code1 {
	WebDriver driver;
	@BeforeTest
	public void  chromedriver1()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
	}
	@Test(dataProvider="credentials")
	public void openapplication(String username,String password)
	{
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("Login")).click();
		//Assert.assertEquals(driver.getTitle(),"Home");
		driver.findElement(By.linkText("SignOut")).click();
		
	}
	@DataProvider
	public Object[][] credentials() throws IOException
	{
		return Excel_sel2.read_data();
		
	}
	@AfterTest
	public void close1()
	{
		driver.close();
	}
}


