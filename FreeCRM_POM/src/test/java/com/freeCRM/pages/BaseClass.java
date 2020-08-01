package com.freeCRM.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.freeCRM.utility.BrowserFactory;
import com.freeCRM.utility.ConfigDataProvider;
import com.freeCRM.utility.ExcelDataProvider;
import com.freeCRM.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		Reporter.log("Setting up Reports and Test Started", true);
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		 
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getcurrentDateTime() +".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done-  Test can be Started", true);
	}
	@BeforeClass
	public void setup()
	{
		Reporter.log("Try to Start Browser and Getting Application ready", true);
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		
		Reporter.log("Browser and Application is up and running", true);
	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to End", true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenShot(driver)).build());
		}
		
		report.flush();
		
		
		Reporter.log("Test is Completed >>> Reports Generated", true);
	}
}
