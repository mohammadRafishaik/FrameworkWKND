package com.testexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Generic.WebCommanmethods;
import com.mongodb.diagnostics.logging.Logger;
import com.seleweb.Webcls;

public class Runcls extends WebCommanmethods {
	public static WebDriver driver;
	public static Webcls appcls;
	@Test(priority=0)
	public void mainexecution() {
		
looger=report.createTest("Login Hrm");
driver=WebCommanmethods.getbrowser("Chrome");
 appcls=PageFactory.initElements(driver, Webcls.class);
appcls.login();
	}
@Test(priority=1)

public void leave() {
looger=report.createTest("Apply Leave");
appcls.applyleave();
looger.pass("Successfully executed");
//looger.fail("Unable to compleate apply leave");
	}
	}

