package POM_Test_Base_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	WebDriver driver;
	
	public void browserintialise() throws InterruptedException
	{
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raju bhau ki Rutuja\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
			
			ChromeOptions opt=new ChromeOptions();

			opt.addArguments("--disable-notifications");


		    driver=new ChromeDriver(opt);
					
			driver.get("https://kite.zerodha.com/");
			
			driver.manage().window().maximize();
		    
			Thread.sleep(1000);
	}

}
