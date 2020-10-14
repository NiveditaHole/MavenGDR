package com.gdr.qa.testCases;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gdr.qa.Base.TestBase;

import com.gdr.qa.pages.UserPage;

public class UserPageTests extends TestBase {

	UserPage userpage;
	//calling constructor
	
	UserPageTests()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		Intialization();

		userpage = new UserPage();

	}



	@BeforeTest
	public void ClickonUSERlINK()
	{
		userpage.ClickonUSERlINK();
	}
	
	@Test
	public void InviteAdmin() throws InterruptedException 
	{
		
		userpage.InviteAdmin();
	}

	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

	
}
