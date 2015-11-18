
package com.mobile.babylon;

import java.net.MalformedURLException;

import com.mobile.util.webConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Hello world!
 *
 */
public class login_android_step 
{
	webConnector connector = new webConnector();
	
	@Given("^I go to babylonApp on \"([^\"]*)\"$")
	public void I_go_to_babylonApp(String DeviceType) throws MalformedURLException, InterruptedException
	{
		System.out.println("I go to babylonApp on "+DeviceType);
		connector.openApplication(DeviceType);
		Thread.sleep(5000);
	}
	@And("^I tap on \"([^\"]*)\"$")
	public void I_tap_on_(String object) throws InterruptedException
	{
		System.out.println("I tap on "+ object);
		connector.click_ID(object);
		Thread.sleep(5000);
	}	
	
	@And("^I tap on \"([^\"]*)\" with classname$")
	public void I_tap_on_classname(String object) throws InterruptedException
	{
		System.out.println("I tap on "+ object);
		connector.click_claseName(object);
		Thread.sleep(5000);
	}
	 @And("^I enter DOB with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$") 
		public void I_enter_DOB(String index1, String index2, String index3) throws InterruptedException
		{
			System.out.println("I enter DOB with "+ index1+ index2+index3);
			connector.Date(index1, index2, index3);
			Thread.sleep(5000);
		}
	@And("^I accept \"([^\"]*)\"$")
	public void I_accept(String object) throws InterruptedException
	{
		System.out.println("I tap on "+ object);
		connector.click_claseName(object);
		Thread.sleep(5000);
	}
	
	@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void I_enter(String object, String text)
	{
		System.out.println("I enter "+object+" as "+text);
		connector.send_input(object, text);
	}
	@And("^I press OK button$")
	public void I_press_OK_button()
	{
		System.out.println("I press ok button");
		connector.ok();
		
	}
	@And("^I tap on checkBox$")
	public void I_tap_on_checkbox()
	{
		System.out.println("And I tap on checkBox");
		connector.checkbox();
	}
	@Then("^I logged in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void I_logged(String element, String text)
	{
		System.out.println("I logged in "+element+"with"+text);
		connector.assert_equals(element, text);
	}
	
	@Then("^I close the application$")
	public void I_close()
	{
		System.out.println("I close the application");
		connector.quit();
		
	}
}
