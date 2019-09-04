package selenium_testng2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wait_Selenium {
	WebDriver driver;
	@BeforeTest
	public void openbrowser()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
	

		
	}
	@Test
	public void openapplication()
	{
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		WebDriverWait webwait=new WebDriverWait(driver,20);
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='userName']")));
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Admin");
		webwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password456");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
	
	}
	@AfterTest
	public void closeapp()
	{
		driver.close();
	}
	

}
