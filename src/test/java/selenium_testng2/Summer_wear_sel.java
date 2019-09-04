package selenium_testng2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Summer_wear_sel{
	WebDriver driver;
	@BeforeTest
	public void openbrowser()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp");


		
	}
	@Test
	public void action_aboutus() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		WebElement search = driver.findElement(By.id("myInput"));
		/*a.keyDown(search,Keys.SHIFT).sendKeys("WEAR").keyUp(Keys.SHIFT).
		sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).click().build().perform();*/
		search.sendKeys("w");
		search.sendKeys("e");
		Thread.sleep(3000);
		search.sendKeys("a");
		search.sendKeys("r");
		
		driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]/div[3]")).click();
		driver.findElement(By.xpath("//input[@name='val']")).click();
		
		
	
	}
	

}
