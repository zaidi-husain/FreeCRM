package com.CRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CRM.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(name= "username")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(xpath= "//input[@type='submit']")
	WebElement loginBtn;
	

}
