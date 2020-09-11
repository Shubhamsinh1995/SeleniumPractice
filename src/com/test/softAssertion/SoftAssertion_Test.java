package com.test.softAssertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion_Test {
	
	// Hard Assertion --> if a hard assertion getting failed --> immediately test case marked as failed and test case will be terminated

	//SoftAssert softAssert=new SoftAssert(); // if a soft assertion getting failed --> test case will not be marked as pass as well as  it  continues to execute the next statement 
	
	@Test
	public void testcase() {
		SoftAssert softAssert1=new SoftAssert(); // provide softAsserion
		
		
		System.out.println(" Open browser");
		Assert.assertEquals(true, true);
		
		System.out.println("Enter usrename and password");
		System.out.println("click on login");
		softAssert1.assertEquals(false, true, "not able to login");
		
		System.out.println("validate home page");
		softAssert1.assertEquals(false, true, "not able to validate home page");
		
		System.out.println("go to deals page");
		System.out.println("go to contacts page");
		
		softAssert1.assertAll();
	}
	
	@Test
	public void testcase2() {
		SoftAssert softAssert2=new SoftAssert();
		System.out.println("return to home page");
		softAssert2.assertEquals(false, true, "failed to return home page");
		softAssert2.assertAll();
	}
}
