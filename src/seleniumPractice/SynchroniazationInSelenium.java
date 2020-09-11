package seleniumPractice;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class SynchroniazationInSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
	  // Wait is an interface and WebDriverWait is a class	
	  //  implicitlywait -- is always applied globally -- is available for all the WebElements	
      //  Dynamic in nature
	  //  it can be Applied anywhere and anytime in your code	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		WebElement username=driver.findElement(By.xpath("//input[@type='text']"));
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		
		sendKeys(driver, username, 10, "shubhambaiyas@gmail.com");
		sendKeys(driver, password, 10, "mahol@1234");
		
		
		WebElement newacct=driver.findElement(By.xpath("//a[@role='button' and @id='u_0_2']"));
		clickOn(driver, newacct, 10);
		
		WebElement fname=driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lname=driver.findElement(By.xpath("//input[@name='lastname']"));
		
		WebElement number=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement newpass=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		WebElement day=driver.findElement(By.xpath("//select[@name='birthday_day']"));
		WebElement month=driver.findElement(By.xpath("//select[@name='birthday_month']"));
		WebElement year=driver.findElement(By.xpath("//select[@name='birthday_year']"));
		WebElement sex=driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		
//		Select select=new Select(day);
//		select.selectByVisibleText("2");
//		
//		Select select1=new Select(month);
//	    select1.selectByVisibleText("Apr");
//		
//		Select select2=new Select(year);
//		select2.selectByVisibleText("1995");
		
		sendKeys(driver, fname, 5, "Shubham");
		sendKeys(driver, lname, 5, "Tope");
		sendKeys(driver, number, 5, "9827467277");
		sendKeys(driver, newpass, 5, "1234567890");
		
		String dob="2-Apr-1995";
		String str[]=dob.split("-");
		
		selectDropdown(day, str[0], "days");
		selectDropdown(month, str[1],"months");
		selectDropdown(year, str[2],"years");
		sex.click();
		
		
		
//		WebElement login=driver.findElement(By.xpath("//button[@name='login']"));
		
	// this method provide explicit Wait 	
//		sendKeys(driver, username, 10, "shubhambaiyas@gmail.com");
//		sendKeys(driver, password, 5, "mahol@1234");
	
	// to click on WebElement
	//	clickOn(driver, login, 5);
	
	}
	
	// ExplicitWait :-->
	//1. there is no explicit keyword or method
	//2. Available with WebDriverWait-- with some expected conditionss
	//3. specific to element
	//4. Dynamic in nature
	//5. We should never use implicit Wait and explicit Wait together
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void selectDropdown(WebElement element, String val, String ele)
	{
		Select select=new Select(element);
		select.selectByVisibleText(val);
		List<WebElement> list=select.getOptions();
		//System.out.println("number of "+ ele+": "+list.size());
		int total=list.size()-1;
		System.out.println();
		System.out.println("number of "+ ele+": "+total);
		
		for(int i=0;i<list.size();i++) {
			String dayVal=list.get(i).getText();
			System.out.println(dayVal);
			}
	}

	}

