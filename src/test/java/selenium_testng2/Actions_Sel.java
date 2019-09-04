package selenium_testng2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions_Sel{
	WebDriver driver;
	@BeforeTest
	public void openbrowser()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp");


		
	}
	@Test
	public void action_aboutus()
	{
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]"))).
		moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our\n" + 
				"												Offices')]"))).
		moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Chennai')]"))).click().build().perform();
	
	}
	@AfterTest
	public void closeapp()
	{
		driver.close();
	}
	

}
