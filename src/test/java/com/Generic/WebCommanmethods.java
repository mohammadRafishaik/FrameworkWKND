package com.Generic;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WebCommanmethods {

	public static  ExtentReports report;
	public static ExtentTest looger;
	
	public static WebDriver driver;
	public static WebDriver getbrowser(String Browser) {
		
		if(Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Dp\\MBS_PROJECT\\Browserdrivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.get("http://www.testingmasters.com/hrm/");
			System.out.println("Chrome is launched");
		}
		else if(Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/MBS_PROJECT/Browserdrivers/geckodriver.exe");
			 driver=new FirefoxDriver();
			 driver.get("http://www.testingmasters.com/hrm/");

			System.out.println("Firefox is launched");	
		}
			
			
		else if(Browser.equals("internetexplorer")) {
			System.setProperty("webdriver.ie.driver", "/MBS_PROJECT/Browserdrivers/IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
			 driver.get("http://www.testingmasters.com/hrm/");

			System.out.println("InternetExplorer is launched");	
				
		}
		else
		{
			System.out.println("nothing is matched");
		}
		return driver;
	}
	public static void closebrowser() {
		driver.close();
		System.out.println("Browser is closed");
	}
	
	public static String getscreenshot() {
		
	TakesScreenshot ts=(TakesScreenshot)driver;
//	String Screenshotpath=System.getProperty("user.dir") + "E:\\Dp\\MBS_PROJECT\\Screenshot_"+gettimestgamp()+".png";
	String Screenshotpath="E:\\Dp\\MBS_PROJECT\\Screenshot\\Scrns\\HRM_"+gettimestgamp()+".png";
	File source=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileHandler.copy(source, new File(Screenshotpath));
	} catch (IOException e) {
		System.out.println("unable to take screenshot "+e.getMessage());
	}
	return Screenshotpath;
	
}

public static String gettimestgamp() {
	DateFormat datevalue=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentdateformet=new Date();
	
	return datevalue.format(currentdateformet);
}

@BeforeSuite
public static void extentsreporsample() {
	
	Reporter.log("Test is started",true);
	ExtentHtmlReporter extent=new ExtentHtmlReporter("E:\\Dp\\MBS_PROJECT\\Reports\\Rep"+gettimestgamp()+".html");
    report=new ExtentReports();
    report.attachReporter(extent);
    Reporter.log("all methods are executed",true);
}


@AfterMethod
public static void capturescreen(ITestResult result) {
	Reporter.log("Attaching screens to report",true);
	if(result.getStatus()==ITestResult.SUCCESS)
	{
		try {
			looger.pass("Test Is success",MediaEntityBuilder.createScreenCaptureFromPath(getscreenshot()).build());
		} catch (IOException e) {
			System.out.println("Screenshot is not attaching"+e.getMessage());
		}
	}

	else if(result.getStatus()==ITestResult.FAILURE) 
	{
		try {
			looger.fail("Test Is Failure",MediaEntityBuilder.createScreenCaptureFromPath(getscreenshot()).build());
		} catch (IOException e) {
			System.out.println("Screenshot is not attaching"+e.getMessage());

		}
	}
	report.flush();
	Reporter.log("Execution is done");
	
	}
public void dropdown(WebElement element,String Value) 
{
 
 Select sel=new Select(element);
 sel.selectByValue(Value);
	
}

}
