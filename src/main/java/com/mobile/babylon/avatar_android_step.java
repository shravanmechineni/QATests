package com.mobile.babylon;

import java.net.MalformedURLException;

import com.mobile.util.webConnector;

import cucumber.api.java.en.Then;

public class avatar_android_step {
	
	webConnector connector = new webConnector();
	
	 @Then("^I click and get the value and Text of \"([^\"]*)\"$")
	 public void I_click_and_get_value_and_text(String Object) throws MalformedURLException, InterruptedException
		{
			System.out.println("I click and get the value and Text of "+Object+" and tap on back button");
			connector.getTheValue(Object);
			Thread.sleep(5000);
		}

	 
	 @Then("^I \"([^\"]*)\"$")
	 public void I_loggedOut(String Object) throws MalformedURLException, InterruptedException
		{
			System.out.println("I "+Object);
			connector.signOut(Object);
			Thread.sleep(5000);
		}
}
