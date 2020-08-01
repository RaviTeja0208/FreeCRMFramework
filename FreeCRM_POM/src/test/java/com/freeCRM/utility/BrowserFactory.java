package com.freeCRM.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrowserFactory {

	@BeforeClass
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
	{
		if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE")){
			driver=new InternetExplorerDriver();
		}
		else{
			System.out.println("we do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	@AfterClass
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
