package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

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
	
	@Test(priority=2)
	public void googleTitleTest() {
		String title=driver.getTitle();
		System.out.println(title);
		
		System.out.println("test-- 2");
		Assert.assertEquals(title, "Google");
	}
	
	@Test(priority=1)
	public void googleLogoTest() {
		boolean b=driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
		System.out.println("Test-- 1");
	}
	
	@Test(priority=3)
	public void mailLinkTest() {
		boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("Test-- 3");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
