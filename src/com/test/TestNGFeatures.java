package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGFeatures {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
	    driver= new ChromeDriver();  // launch chrome
	    
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	@Test
	public void loginTest() {
		System.out.println("login Test");
		int i=2/0;                          // if this test fails other two tests will be skipped
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void RegisterTest() {
		System.out.println("register page --test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void searchpagetest() {
		System.out.println("Search Page --Test");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
