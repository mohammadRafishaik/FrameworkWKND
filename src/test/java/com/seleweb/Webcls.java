package com.seleweb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Generic.WebCommanmethods;

public class Webcls {
	Exceldatareader testdata=new Exceldatareader();
	//Login Objects
	@FindBy(id="txtUsername")WebElement Username;
	@FindBy(id="txtPassword")WebElement password;
	@FindBy(name="Submit")WebElement loginbutton;
	
	//Apply LeaveTab Objects
	@FindBy(id="menu_leave_viewLeaveModule")WebElement Leavtab;
	@FindBy(id="menu_leave_applyLeave")WebElement Applytab;
	@FindBy(id="applyleave_txtLeaveType")WebElement leavetype;
	@FindBy(xpath="//select[@id='applyleave_txtLeaveType']/option[2]")WebElement option;
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
	leavetype.click();
	option.click();
	
	

	}
	
	
	
	

}
