package com.mobile.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class webConnector {
	
	
	public static Properties OR  = null;
	public static Properties CONFIG  = null;
	public static DesiredCapabilities capabilities = null;
	public static AndroidDriver driver = null;
	public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	
		public webConnector()
		{
			if(OR == null)
			{
				try 
				{
					//Initilization of OR property file
					OR = new Properties();
					
					FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/mobile/config/OR.properties");
					OR.load(fs);
					
					CONFIG = new Properties();
					fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/mobile/config/staging_config.properties");
					CONFIG.load(fs);
					
					System.out.println(OR.getProperty("loginButton"));
					System.out.println(CONFIG.getProperty("usernameText1"));
					
				} 
				catch (Exception e) 
				{
					System.out.println("error in initialization");
				
				}
			}
		}
		
		
		//open_Application
		public void openApplication(String DeviceType) throws MalformedURLException
		{
			if(DeviceType.equals("Galaxy S5"))
			{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability("deviceName", "Galaxy S5");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("platformVersion", "5.0");
				File app = new File(System.getProperty("user.dir")+"//Babylon_2.1.apk");
				capabilities.setCapability("app", app.getAbsolutePath());
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
		//close the Application
		public void quit()
		{
			try{
				if(driver!=null)
					driver.quit();
			}
			catch(NoSuchMethodError  method)
			{
				method.printStackTrace();
			}
		}
		
		public void ok()
		{
			try{
				driver.findElementByAndroidUIAutomator("new UiSelector().text(\"OK\")").click();
			}
			catch(NoSuchMethodError  e)
			{
				e.printStackTrace();
			}
		}
		
		public void checkbox()
		{
			try{
				 WebElement checkBox = driver.findElement(By
				            .className("android.widget.CheckBox"));
				    if (checkBox.isSelected()) {
				        checkBox.click();
				    }
			}
			catch(NoSuchMethodError  e)
			{
				e.printStackTrace();
			}
		}
		
		//Click _Xpath
			 public void click_Xpath(String element)   
			 { 
				 try {				 	
						 driver.findElement(By.xpath(OR.getProperty(element))).click();
					} catch (NoSuchElementException err) {
						
						err.printStackTrace();
						 APPLICATION_LOGS.debug(element + " notfound ");
					}
			 }
			 

	// Click_ID
	public void click_ID(String element) {
		try {
			driver.findElement(By.id(OR.getProperty(element))).click();
		} catch (NoSuchElementException err) {

			err.printStackTrace();
			APPLICATION_LOGS.debug(element + " notfound ");
		}
	}
			 
			 
	// Click_ClassName
	public void click_claseName(String element) {
		try {
			driver.findElement(By.className(OR.getProperty(element))).click();
		} catch (NoSuchElementException err) {

			err.printStackTrace();
			APPLICATION_LOGS.debug(element + " notfound ");
		}
	}
					 
			 
			 //Send_text
			 public void send_input(String element, String text)
			 {
				 try 
				 {
					driver.findElement(By.id(OR.getProperty(element))).sendKeys(CONFIG.getProperty(text));
				 } 
				 catch (NoSuchElementException err) {
					err.printStackTrace();
					APPLICATION_LOGS.debug(element + " not found ");
				}
			 }
			 //Assert
			 public void assert_equals(String text, String element)
			 {
				 try 
				 {
				 Assert.assertEquals(driver.findElement(By.id(OR.getProperty(element))).getText(), CONFIG.getProperty(text));
				 } 
				 catch (NoSuchElementException err) {
						err.printStackTrace();
						APPLICATION_LOGS.debug(element + " not found ");
					}
			 }
			
			// List_webelementswtihClassName
				public void getTheValue(String ID) throws InterruptedException
				{
						 try {				 	
							 List<WebElement> viewNames = driver.findElements(By.className(OR.getProperty(ID)));
							 System.out.println("Get the Value of Setting Menu--->" + viewNames.size());
							 Thread.sleep(5000);
							 
							 for(WebElement viewName : viewNames)
							 {
								 System.out.println(viewName.getText());
							 }
							} catch (NoSuchElementException err) {
								
								err.printStackTrace();
								 APPLICATION_LOGS.debug(ID +   " notfound ");
							}
				}
				
				public void Date(String Index1, String Index2, String Index3)
				{
					try 
					{
						driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys(CONFIG.getProperty(Index1));
						driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys(CONFIG.getProperty(Index2));
						driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys(CONFIG.getProperty(Index3));
					}
				catch (NoSuchElementException err) {
					
					err.printStackTrace();
					 APPLICATION_LOGS.debug(Index1 + Index2  + Index3 +   " notfound ");
				}
				}
				
				public void signOut(String ID)
				{
					 try {				 	
						 driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Sign Out\")").click();
						} catch (NoSuchElementException err) {
							
							err.printStackTrace();
							 APPLICATION_LOGS.debug(ID +   " notfound ");
						}
				}
				
}

