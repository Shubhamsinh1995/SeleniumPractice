package seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HighlightElement {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("shubhambaiyas@gmail.com");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("9730183655");
		//driver.findElement(By.xpath("//button[@name='login']")).click();
		
		WebElement loginBtn=driver.findElement(By.xpath("//button[@name='login']"));
		
		flash(loginBtn, driver);  // highlight the element
		
		drawBorder(loginBtn, driver); // draw a border
		
		captureScreenshot(driver); // takes screenShot and store as a file format 
		
		// genert Alert
//		generateAlert(driver, "There is an issue with login button or login page");
//		Thread.sleep(3000);
//		Alert alert=driver.switchTo().alert();
//		alert.accept();
		
		//clickElementByJS(driver, loginBtn);
		
		// get the title of the page by JS
		System.out.println(getTitleByJS(driver));
		
		// get inner text of page
		System.out.println(getInnerText(driver));
		
		// to scroll down the page
		scrollDownPage(driver);
		
		WebElement signUp=driver.findElement(By.xpath("//a[@title='Sign up for Facebook']"));
		
		// scroll up to perticular element is visible
		scrollIntoview(signUp, driver);
		
		//driver.quit();

	} 
	
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<=4;i++) {
			changeColor("rgb(200,0,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+ color +"'", element);
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void captureScreenshot(WebDriver driver) throws Exception
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        com.google.common.io.Files.copy(src,new File("./ScreenShots/facebook.png"));

		
	}
	
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message +"')");
	}
	
	public static void clickElementByJS(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
	}
	
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getInnerText(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollDownPage(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoview(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

}
