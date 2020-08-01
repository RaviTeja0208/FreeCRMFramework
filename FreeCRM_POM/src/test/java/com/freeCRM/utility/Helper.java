package com.freeCRM.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String CaptureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/FreeCRM "+getcurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File("./Screenshots/FreeCRM "+getcurrentDateTime()+".png"));
			System.out.println("Screenshot captured Successfully");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getcurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
}
