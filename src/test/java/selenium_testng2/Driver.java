package selenium_testng2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	public static WebDriver configuredriver(String browsername)
	{
		WebDriver driver = null;
		if (browsername.equals("explorer"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\suma.uddan\\Downloads\\IEDriverServer_x64_3.14.0\\geckodriver.exe");
			driver =new InternetExplorerDriver();
		}
		else if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\suma.uddan\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
		}
	
		return driver;
		
	}
	
}
