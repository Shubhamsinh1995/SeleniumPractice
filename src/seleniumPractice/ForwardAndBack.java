package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForwardAndBack {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
	// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
	// it can be changed anywhere and at any time in your code
	// it is dynamic in nature	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//driver.get("https://www.facebook.com/");
		driver.get("https://freecrm.co.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		driver.findElement(By.xpath("//input[@type='text' and @name='email']")).sendKeys("shubhambaiyas@gmail.com");
		driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("1234567");
		
//		driver.navigate().to("http://www.google.com");
//		System.out.println(driver.getTitle());
		
//		driver.navigate().back();  // click on back button of browser
//		Thread.sleep(2000);
//		driver.navigate().forward(); // click on forward button of browser
//		Thread.sleep(2000);
//		driver.navigate().refresh();

	}

}
