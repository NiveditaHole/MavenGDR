package com.gdr.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gdr.qa.Base.TestBase;
import com.gdr.qa.Utility.ScreenshotUtility;
import com.gdr.qa.Utility.WaitTimeUtil;

public class UserPage extends TestBase{
	
	
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/app-logo-header/nav/div[3]/ul[1]/li[4]/a")
	WebElement UserLink;
	
	@FindBy(xpath="//span[@class='invitenewuser']")
	WebElement InviteUser;
	
	@FindBy(xpath="//input[@id='mat-input-4']")
	WebElement FirstName;
	

	@FindBy(xpath="//input[@id='mat-input-5']")
	WebElement LasttName;

	
	@FindBy(xpath="//input[@id='mat-input-6']")
	WebElement EmailUser;
	
	@FindBy(xpath="//input[@id='mat-input-8']")
	WebElement phoneUser;
	
	@FindBy(xpath="//select[@id='mat-input-7']")
	WebElement SelectRole;
	
	

	@FindBy(xpath="")
	WebElement Accounts;
	
	
	@FindBy(xpath="//*[@id=\"mat-dialog-3\"]/app-inviteuserdialog/div[4]/div[1]/button")
	WebElement SaveUpdate;
	
	@FindBy(xpath="//*[@id=\"mat-dialog-4\"]/app-invite-user-success-dialog/div/div[2]/div/button/span")
	WebElement done;
	
	@FindBy(xpath="/html/body/app-root/app-usersadminview/div[2]/div[3]/div[2]/mat-table/mat-row[1]/mat-cell[9]/button/a")
	WebElement Userdetail;


	
	
	
	
	
	//calling constructor
	//Initialization
	

	
		public UserPage() {
			PageFactory.initElements(driver, this);
		}
		
		//ALL Actions
	
		

     public void InviteAdmin() throws InterruptedException
     {
    	 
    	 
    	//UserLink.click();
    	Thread.sleep(10000);
    	InviteUser.click();
    	
    	 FirstName.sendKeys("NIvedita");
    	 LasttName.sendKeys("Jack");
    	 EmailUser.sendKeys("TestAdmin1@gmail.co");
    	 phoneUser.sendKeys("8888342345");
    	 
    	 Select AdminRole= new Select(SelectRole);
    	 AdminRole.selectByIndex(1);
 		 WebElement selectedrole=AdminRole.getFirstSelectedOption();
 		String roleselected=selectedrole.getText();
 		 System.out.println("role selected is " +roleselected);
 		 
 		SaveUpdate.click();
 		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
 		done.click();
 		Userdetail.click();
 		driver.manage().timeouts().implicitlyWait(WaitTimeUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
 		ScreenshotUtility.CaptureScreenshots(driver);
 		
 	
    	 
    	   
		 
    
    }
     /*
     public void InviteSAASDriver() throws InterruptedException
     {
    	 
    	 
    	Thread.sleep(10000);
    	InviteUser.click();
    	
    	 FirstName.sendKeys("NIvedita");
    	 LasttName.sendKeys("Jack");
    	 EmailUser.sendKeys("TestAdmin1@gmail.co");
    	 phoneUser.sendKeys("8888342345");
    	 
    	 Select AdminRole= new Select(SelectRole);
    	 AdminRole.selectByIndex(4);
 		 WebElement selectedrole=AdminRole.getFirstSelectedOption();
 		String roleselected=selectedrole.getText();
 		 System.out.println("role selected is " +roleselected);
 		 
 		SaveUpdate.click();
 		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
 		done.click();
 		Userdetail.click();
 		driver.manage().timeouts().implicitlyWait(WaitTimeUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
 		ScreenshotUtility.CaptureScreenshots(driver);
 		
 	
    	 
    	   
		 
    
    }
*/
	public void ClickonUSERlINK() throws InterruptedException {
		// TODO Auto-generated method stub
		wait=new WebDriverWait(driver, 20);
   	 WebElement DashboardText;
   	 DashboardText= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-dashboard/div[2]/div[2]/div[1]/div[1]/mat-card/mat-card-header/div/mat-card-title[2]/div")));

       DashboardText.getText();
        Thread.sleep(5000);
		UserLink.click();
		
	}	 
     
     
	
}
