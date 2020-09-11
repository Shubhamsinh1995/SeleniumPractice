package com.dataDriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		// WebDriver code
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=");
		
		
	// get the data from excel	
	Xls_Reader reader=new Xls_Reader("C:\\my java\\SeleniumSession\\src\\com\\testData\\halfEbeyTestData.xlsx");
	int rowcount=reader.getRowCount("RegTestData");
	// reader.addColumn("RegTestData", "Status"); // add column to excel file
	
	// Parameterization
	for(int rowNum=2;rowNum<=rowcount;rowNum++) {
		System.out.println();
		String firstname=reader.getCellData("RegTestData", "firstname", rowNum);
		System.out.println(firstname);
		
		String lastname=reader.getCellData("RegTestData", "lastname",rowNum);
		System.out.println(lastname);
		
		String emailaddress=reader.getCellData("RegTestData", "emailaddress", rowNum);
		System.out.println(emailaddress);
		
		String password=reader.getCellData("RegTestData", "password", rowNum);
		System.out.println(password);
		
		
		// enret data
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(firstname);
		
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailaddress);
		
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
		
		// reader.setCellData("RegTestData", "Status", rowNum, "Pass");  // write data into cell
	}
}
}