package selenium_testng2;

import java.io.File;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreports_Sel {
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void startReport()
	{
		driver=Driver.configuredriver("chrome");
		driver.manage().window().maximize();
		//location of maven project
		String path=System.getProperty("user.dir")+"/extent-reports/reports.html";
		//test report
		reporter=new ExtentHtmlReporter(path);
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("HostName", "Next Generation Automated Testing");
		extent.setSystemInfo("Environment", "Selemium automated Tets");
		extent.setSystemInfo("UserName", "Suma");
		reporter.config().setDocumentTitle("TesMeApp");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("TestMe Application");
		driver.get("http://10.232.237.143:443/TestMeApp");
		//driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	}
	@Test(priority=1)
	public void testRegistraion()
	{
		
		logger=extent.createTest("TestRegistration","customers register in TestMeApp");
		driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("sumaudan1234");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("suma");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("uddan");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='pass_confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@value='Female']")).isSelected();
		driver.findElement(By.xpath("//input[@id='emailAddress']")).sendKeys("sumauddan234@gmail.com");
		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("1234567890");
		//driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("01/09/1997");
		driver.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[9]/div/div/img")).click();
		Select category=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		category.selectByVisibleText("1997");
		Select category1=new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		category1.selectByVisibleText("Aug");
		driver.findElement(By.linkText("26")).click();

		driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("sssssssssssssssss");
		//driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]")).click();
		driver.findElement(By.xpath("//option[@value='411010']")).click();
		
		driver.findElement(By.xpath("//input[@id='answer']")).sendKeys("jjjjjjjjjjooooo");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		
		
		
		//driver.findElement(By.xpath("//a[@href='RegisterUser.htm']")).click();
		
		//test code of registraion
		//Assert.assertTrue(true);
		
	}
	
	
	@Test(priority=2)
	public void testLogin(String username,String password)
	{
		logger=extent.createTest("TestLogin","user login into TestMeApp");
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.name("Login")).click();
		//Assert.assertEquals(driver.getTitle(),"Home");
		
		//Assert.assertTrue(false);
		
		
	}
	
	/*@Test(priority=3)
	public void testAddToCart()
	{
		logger=extent.createTest("TestAddToCart","user adds products to the crat of TestMeApp");
	}
	@Test(priority=4)
	public void testPayment()
	{
		logger=extent.createTest("TestPayment","user pay the bill for products");
		throw new SkipException("this test has to be coded");
	}*/
	@AfterMethod
	public void getResult(ITestResult report) throws IOException
	{
		if(report.getStatus()==ITestResult.SUCCESS)
		{
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Passed",ExtentColor.GREEN));
		}
		else if(report.getStatus()==ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel("Test Failed",ExtentColor.RED));
			TakesScreenshot capture=(TakesScreenshot)driver;
			File source=capture.getScreenshotAs(OutputType.FILE);
			String imgpath=System.getProperty("user.dir"+"/extent-reports/snapshots/"+report.getName()+"png");
			FileUtils.copyFile(source, new File(imgpath));
			logger.addScreenCaptureFromPath(imgpath,report.getName());
		}
		else if (report.getStatus()==ITestResult.SKIP) 
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel("Test Skipped", ExtentColor.BLUE));
		}
	}
	
	//if you want to skip the test intentionally then 
	//throw new SkipException("this test has to be coded");
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}

}
