package selenium_testng2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_Excel {
	WebDriver driver;
	@BeforeTest
	public void  chromedriver1()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test()
	public void openapplication()
	{
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		Actions a=new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'All\n" + 
				"										Categories')]"))).
		moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"))).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Travel Kit')]"))).click().build().perform();
		a.moveToElement(driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a"))).click().perform();
		driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		
		
		a.moveToElement(driver.findElement(By.xpath("//*[@id=\"swit\"]/div[2]/div/label/i"))).click().perform();
		driver.findElement(By.xpath("//a[@id='btn']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		a.moveToElement(driver.findElement(By.xpath("//input[@value='LOGIN']"))).click().perform();
		//driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		//driver.findElement(By.xpath(""))
		
		
		
	}

}


