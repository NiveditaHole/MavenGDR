package com.gdr.qa.testCases;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gdr.qa.Base.BeforeLoginBase;
import com.gdr.qa.Base.TestBase;

import com.gdr.qa.Utility.ValidateEmailUtility;
import com.gdr.qa.pages.DashboardPage;
import com.gdr.qa.pages.LoginPage;



public class LoginPageTest extends BeforeLoginBase {

	LoginPage loginPage;
	DashboardPage homepage;

	public LoginPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		Intialization();

		loginPage = new LoginPage();

	}
	
	
	

	@Test
	public void loginTest() 
	{

		loginPage.loginwithValid(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void VerifyTitle() {
		String title = loginPage.VerifyTitle();
		Assert.assertEquals(title, "Goodr dashboard");
	}

	@Test
	public void VerifyPrivacyLink()
	{
		Boolean flag = loginPage.VerifyPrivacyLink();
		Assert.assertTrue(flag);
	}
	

	@Test
	public void LoginwithBlankdata() 
	{
		

		if (driver.getPageSource().contains("Please enter fields"))
		{
			System.out.println("validation is present for Empty Data login");
		}
		
		}
	
	
	@Test 
	public void Testdata()
	{
	//create the obj of lib class where code is written from excel read which you can use anywhere
	
	
	/*	ExcelReadTest excel= new ExcelReadTest("/home/niveditah/Downloads/Excel/testdata.xlsx");
		System.out.println(excel.getData(0, 0,1));
		
		System.out.println(excel.getData(1, 0,0));
		System.out.println(excel.getData(0, 1,1));
		System.out.println(excel.getData(2, 1,1));
	*/
	}
	



	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
