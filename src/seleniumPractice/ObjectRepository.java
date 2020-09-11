package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectRepository {

	 static WebDriver driver;
	 public static void main(String[] args) throws IOException {
	
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\my java\\SeleniumSession\\src\\seleniumPractice\\config.properties");
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String url=prop.getProperty("URL");
		System.out.println(url);
		
		String browser_name=prop.getProperty("browser");
		System.out.println(browser_name);
		
		if(browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		    driver= new ChromeDriver();
			
		// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		else {
			System.out.println("no such name available");
		}
		
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("firsrname_Xpath"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath(prop.getProperty("lastname_Xpath"))).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath(prop.getProperty("email_Xpath"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("password_Xpath"))).sendKeys(prop.getProperty("password"));
		
		
		
		
		
	}

	
}

