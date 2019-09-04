package selenium_testng2;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Reg_Selenium {
	WebDriver driver;
	@BeforeTest
	public void openchrome()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
		//driver.get("http://10.232.237.143:443/TestMeApp");
		driver.get("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");
		
	}
	@Test(dataProvider="credentials")
	public void user_registration(String username,String firstname,String lastname,String password,String C_password,String gender,String email,String mobile,String y,String m,String d,String address,String answer )
	{
		//driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='pass_confirmation']")).sendKeys(C_password);
		driver.findElement(By.xpath("//input[@value='Female']")).isSelected();
		driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys(mobile);
		//driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("01/09/1997");
		driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img")).click();
		Select category=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		category.selectByVisibleText(y);
		Select category1=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		category1.selectByVisibleText(m);
		driver.findElement(By.linkText(d)).click();

		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(address);
		//driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
		driver.findElement(By.xpath("//option[@value='411010']")).click();
		
		driver.findElement(By.xpath("//input[@id='answer']")).sendKeys(answer);
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
	}
	@DataProvider
	public Object[][] credentials() throws IOException
	{
		return Excel_reg.read_data();
		
	}

}
