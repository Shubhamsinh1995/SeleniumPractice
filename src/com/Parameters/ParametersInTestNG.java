package com.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParametersInTestNG {

	WebDriver driver;
	@Test
	@Parameters({"browser", "url", "emailId", "password"})
	public void  loginFacebookTest(String browser, String url, String emailId, String password) {
		
		if(browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.out.println("u dont have firefox");
		}
		driver.get(url);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailId);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"u_0_b\"]")).click();
	}
}
