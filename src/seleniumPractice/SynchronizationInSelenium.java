package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationInSelenium {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
	// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
	// it can be changed anywhere and at any time in your code
	// it is dynamic in nature	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		
		WebElement firstname=driver.findElement(By.name("firstname"));
		WebElement lastname=driver.findElement(By.name("lastname"));
		WebElement mobnum=driver.findElement(By.name("reg_email__"));
		WebElement password=driver.findElement(By.name("reg_passwd__"));
		
		sendKeys(driver, firstname, 10, "shubham");
		sendKeys(driver, lastname, 10, "baiyas");
		sendKeys(driver, mobnum, 10, "9730183655");
		sendKeys(driver, password, 10, "shubham@1234");
		
		WebElement link=driver.findElement(By.linkText("Forgotten account?"));
		clickOn(driver, link, 5);
	}
   
	//Explicit Wait:
	// No such Explicit keyword or method in Selenium
	// available with WebDriverWait with some expected conditions
	// specific to particular element
	// dynamic in nature
	// we should not apply implicitly wait and Explicit wait together-- bcoz it will add both the implicit and explicit wait
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value)   // this sendKeys() is userdefined
	{	
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		
		element.sendKeys(value); // this senKeys method already defined in selenium
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
}









