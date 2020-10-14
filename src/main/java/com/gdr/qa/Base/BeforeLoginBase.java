package com.gdr.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gdr.qa.Utility.WaitTimeUtil;

public class BeforeLoginBase {


		public static WebDriver driver;
		public static Properties prop;

		// constructor
		public BeforeLoginBase() {
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						"/home/niveditah/eclipse-workspace/GoodrTest/src/main/java/com/gdr/qa/config/config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void Intialization() 
		
		{
			String browsername = prop.getProperty("browser");
			
			if (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/home/niveditah/Downloads/chrome80/chromedriver");
				driver = new ChromeDriver();
				
			} 
			
			else if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "/home/niveditah/Downloads/FF/geockdriver");
				// driver= new geckoDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			// taking wait from util fle and we can change timeout time from util
			driver.manage().timeouts().pageLoadTimeout(WaitTimeUtil.PAGE_LOADTIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(WaitTimeUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));
	      
	        
	      
	     
	        
	    	}
	    	

		}




