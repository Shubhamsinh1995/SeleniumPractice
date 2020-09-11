package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
 /* setup the system property for chrome
	launch chrome browser
	login to app
	Enter URL
	Google title test
	log out from the app
	Enter URL
	clickonSearchBtn
	log out from the app
	close the browser
	delete all cockies */

	@BeforeSuite  //1
	public void setup() {
		System.out.println("setup the system property for chrome");
	}
	
	@BeforeTest  //2
	public void launchBrowser() {
		System.out.println("launch chrome browser");
	}
	
	@BeforeClass  //3
	public  void login() {
		System.out.println("login to app");
	}
	
	@BeforeMethod  //4, 7
	public void enterURL() {
		System.out.println("Enter URL");
	}
	
	// test cases --starting with @Test
	@Test(priority=1)  //5
	public void googleTitletest() {
		System.out.println("Google title test");
	}
	
	@Test(priority=2)  // 8
	public void clickonSearchBtn() {
		System.out.println("clickonSearchBtn");
	}
	
	@Test(priority=3)
	public void googleLogoTest() {
		System.out.println("google logo test");
	}
	
	/*
	 * @BeforeMethod 
	 * @test -1
	 * @AfterMethod 
	 * 
	 * @BeforeMethod
	 * @Test -2
	 * @AfterMethod
	 */
	
	@AfterMethod   //6, 9
	public void logout() {
		System.out.println("log out from the app");
	}
	
	@AfterClass  //10
	public void closeBrowser() {
		System.out.println("close the browser");
	}
	
	@AfterTest  //11
	public void deleteAllcockies() {
		System.out.println("delete all cockies");
	}
	
	
	
	
}
