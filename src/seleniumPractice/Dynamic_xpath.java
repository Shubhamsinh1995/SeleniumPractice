package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dynamic_xpath {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		driver.get("https://ui.freecrm.com/");
		String title=driver.getTitle();
		System.out.println(title);
		
	//	driver.findElement(By.xpath("//a[.='Log In']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("baiyasshubham@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Mahol@1234");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		

		//driver.findElement(By.xpath("//div[@class='dropdown']//button[@type='button' and @class='btn btn-secondary dropdown-toggle' and @id='dropdownMenuButton']")).click();
       
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		driver.findElement(By.xpath("//td[text()='Akshay bhagat']//preceding-sibling::td[@class='']//div[@class='ui fitted read-only checkbox']")).click();
		driver.findElement(By.xpath("//td[text()='shubham pradip baiyas']")).click();
	}

}  
