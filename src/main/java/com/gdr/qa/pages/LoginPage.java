package com.gdr.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gdr.qa.Base.BeforeLoginBase;


public class LoginPage extends BeforeLoginBase {

	// this class will store all the locators and methods
	// page factory or obj repo

	@FindBy(xpath = "//*[@id=\"emailadd\"]")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"mat-input-1\"]")
	WebElement password;

	@FindBy(xpath = "/html/body/app-root/app-login/section/div/div[2]/form/mat-card-actions/button")
	WebElement LoginBtn;

	@FindBy(xpath = "/html/body/app-root/app-login/section/div/div[2]/form/mat-card-content/div/div[2]/span")
	WebElement ForgetpwdLink;

	@FindBy(xpath = "/html/body/app-root/app-login/section/div/div[2]/form/mat-card-content/div/div[1]/a/u/a")
	WebElement PrivacyLink;

	// Initialization

	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}

	// Actions
	
	
	public void LoginTest(String usernameValue, String passwordvalue )
	{
		username.sendKeys(usernameValue);
		password.sendKeys(passwordvalue);
		
		//login button
		LoginBtn.click();
		
	}

	public DashboardPage loginwithValid(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);

		LoginBtn.click();
		return new DashboardPage();
	}

	public String VerifyTitle() {
		return driver.getTitle();

	}

	public Boolean VerifyPrivacyLink() {
		PrivacyLink.click();
		return PrivacyLink.isEnabled();
	}
	public void LoginwithBlankdata()
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		LoginBtn.click();
	}

}
