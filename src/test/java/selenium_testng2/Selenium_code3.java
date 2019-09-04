package selenium_testng2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_code3 {
	WebDriver driver;
	@BeforeTest
	public void openbrowser()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
		driver.navigate().to("http://10.232.237.143:443/TestMeApp/login.htm");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
	@Test
	public void openapplication()
	{
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password456");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		driver.findElement(By.xpath("//div[@class='btn-group'][4]")).click();
		Select category=new Select(driver.findElement(By.id("categorydropid")));
		category.selectByVisibleText("Electronics");
		Select sub_cat=new Select(driver.findElement(By.id("subcategorydropid")));
		sub_cat.selectByVisibleText("Travel Kit");
		driver.findElement(By.xpath("//input[@value='View Products']")).click();
		
		
	
	}
	

}
