package com.freeCRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
	}

	@FindBy(name="username")WebElement uidelement;
	
	@FindBy(name="password")WebElement pwdelement;
	
	@FindBy(xpath="//input[@class='btn btn-small'and@type='submit']") WebElement loginbutton;
	
	public void LoginToCRM(String uname,String pswd){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		uidelement.sendKeys(uname);
		pwdelement.sendKeys(pswd);
		loginbutton.click();
	}
}
