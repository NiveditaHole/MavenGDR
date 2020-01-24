package Example;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Library.isEmailValid;

public class LoginFunctionality extends ExtendReportDemo{

	
	@BeforeMethod
    public void Login() 
	{
		// extent report
		
	test =reports.createTest("Opening the URL");
	test.log(Status.INFO, "URL link is open");
	
	
	System.setProperty("webdriver.chrome.driver","/home/niveditah/Downloads/chrome74/chromedriver");
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    //url 
    driver.get("http://gdr-dev-dashboard-3-0.eastus.cloudapp.azure.com");	
	
	
    
	}
	@Test
    public void LoginBlankdata() throws InterruptedException
    {
		
		test =reports.createTest("Blank data validation");
		test.log(Status.INFO, "Blank data validation passed");	
		//test.log(Status.PASS,"Blank data validation passed");
		//test.log(Status.FAIL,"Blank data validation Failed");
	
	//login button
		driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/form/mat-card-actions/button")).click();
	 if(driver.getPageSource().contains("Please enter fields"))
	 {
	System.out.println("validation is present for login button with empty username and password");	 
	 }
    }
	
	@Test
	public void CheckInvalidEmailId() throws InterruptedException
	{

    	test =reports.createTest("Invalid Email Scenario");
    	test.log(Status.INFO, "Checking the email validation ");
    	 driver.findElement(By.xpath("//*[@id=\"emailadd\"]")).sendKeys("gfhfghgmail.com");
	    WebElement targetEmail = driver.findElement(By.xpath("//*[@id=\"emailadd\"]"));
	    String getValue = targetEmail.getAttribute("value");
		System.out.println("email entered :" +getValue);
		
		if (isEmailValid.isValid(getValue))
		{
		 
	        
	            System.out.print("email is Valid"); 
	 	}
	        else
	        {       System.out.print("email is not valid"); 
		
	        }
		
   	}
	@Test
	public void CheckValidEmailId() throws InterruptedException
	{

    	test =reports.createTest("Valid Email Scenario");
    	test.log(Status.INFO, "Checking the email validation ");
    	
    	 driver.findElement(By.xpath("//*[@id=\"emailadd\"]")).sendKeys("abc@gmail.com");
	    WebElement targetEmail = driver.findElement(By.id("//*[@id=\\\"emailadd\\\"]"));
	    String getValue = targetEmail.getAttribute("value");
		System.out.println("email entered :" +getValue);
		
		if (isEmailValid.isValid(getValue))
		{
		 
	        
	            System.out.print("email is Valid"); 
	 	}
	        else
	        {       System.out.print("email is not valid"); 
		
	        }
	}
	@Test(enabled=false)
	public void LoginEmailID()
    {
		test =reports.createTest("Blank email scenario");
    	test.log(Status.INFO, "Checking the email validation ");
		//login button
		driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Trinesis_123");
	 driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/form/mat-card-actions/button")).click();
	 if(driver.getPageSource().contains("Please enter fields"))
	 {
	System.out.println("validation is present for Empty userNAME");	 
	 }
    }
	@Test(enabled=false)
	public void LoginwithValidData()
	{
		
		test =reports.createTest("**Login with Valid Data");
    	test.log(Status.PASS, "Suceessfully logged in");
		 driver.findElement(By.xpath("//*[@id=\"emailadd\"]")).sendKeys("avinash@trinesis.com");
			driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Trinesis_123");
			//login button
			driver.findElement(By.xpath("/html/body/app-root/app-login/section/div/div[2]/form/mat-card-actions/button")).click();
            System.out.println(driver.getTitle()); 
			
	}
	
	
	 
	
	
}