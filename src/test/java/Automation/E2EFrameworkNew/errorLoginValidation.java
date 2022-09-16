package Automation.E2EFrameworkNew;

import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.RetryAnalyzerDemo;
import browserInitalize.BrowserInitialize;

public class errorLoginValidation extends BrowserInitialize {

	@Test(groups="Error Validation",retryAnalyzer=RetryAnalyzerDemo.class)
	public void ErrorLoginValidation() {
		lp.LoginToSite("johnhbomb310@gmail.com", "Testing1234");
		Assert.assertEquals(lp.FailedLoginError(), "Incorrect email1 or password.");
		System.out.println("Test1");
		System.out.println("Test2");
		System.out.println("Test3");
	}
	
	
}
