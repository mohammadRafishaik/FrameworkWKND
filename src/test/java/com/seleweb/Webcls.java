package com.seleweb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Generic.WebCommanmethods;

public class Webcls {
	Exceldatareader testdata=new Exceldatareader();
	WebCommanmethods webc=new WebCommanmethods();
	//Login Objects
	@FindBy(id="txtUsername")WebElement Username;
	@FindBy(id="txtPassword")WebElement password;
	@FindBy(name="Submit")WebElement loginbutton;
	
	//Apply LeaveTab Objects
	@FindBy(id="menu_leave_viewLeaveModule")WebElement Leavtab;
	@FindBy(id="menu_leave_applyLeave")WebElement Applytab;
	@FindBy(xpath="//select[@id='applyleave_txtLeaveType']") WebElement Leavetype;
@FindBy(id="applyleave_txtFromDate")WebElement fromdate;
@FindBy(className="ui-datepicker-year")WebElement year;

	public void login() {
		String username=testdata.getstringgetdata("Sheet1", 1, 1);
		String Password=testdata.getstringgetdata("Sheet1", 1, 2);
		Username.sendKeys(username);
		password.sendKeys(Password);
		loginbutton.click();
	
		}
	
	public void applyleave() {
	Leavtab.click();
	Applytab.click();
	
	webc.dropdown(Leavetype, "1");
	
	fromdate.click();
	webc.dropdown(year, "2020");
	

	}
	
	
	
	

}
