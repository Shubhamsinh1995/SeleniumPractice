package com.dataDriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class DataDrivenTest {

	
	public static void main(String[] args) {
		
		Xls_Reader reader=new Xls_Reader("C:\\my java\\SeleniumSession\\src\\com\\testData\\halfEbeyTestData.xlsx");
		int rowcount=reader.getRowCount("RegTestData");
		System.out.println(rowcount);
		System.out.println();
	
		String firstname=reader.getCellData("RegTestData", "firstname", 2);
		System.out.println(firstname);
		
		String lastname=reader.getCellData("RegTestData", "lastname", 2);
		System.out.println(lastname);
		
		String emailaddress=reader.getCellData("RegTestData", "emailaddress", 2);
		System.out.println(emailaddress);
		
		String password=reader.getCellData("RegTestData", "password", 2);
		System.out.println(password);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=");
		
		
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstname);
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailaddress);
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
		
		
		
				
	}

}
