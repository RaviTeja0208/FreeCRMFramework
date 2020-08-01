package com.freeCRM.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.freeCRM.pages.BaseClass;
import com.freeCRM.pages.LoginPage;


public class LoginTestCRM extends BaseClass{
		
	
	@Test
	public void loginapp()
	{
		logger=report.createTest("Login to CRM ");
		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		lp.LoginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login Successful");
				
	}
	
}
