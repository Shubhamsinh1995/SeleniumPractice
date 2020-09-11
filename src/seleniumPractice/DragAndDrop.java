package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
	// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/html5_draganddrop.asp");
		driver.switchTo().frame(0);
		
		 WebElement src=   driver.findElement(By.id("div1"));
	     WebElement trgt=  driver.findElement(By.id("div2"));
	     
	     Actions action=new Actions(driver);
	     action.clickAndHold(src).moveToElement(trgt).release().build().perform();
	     //action.dragAndDrop(src, trgt).build().perform();
	}

}
