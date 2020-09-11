package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicWebTable {

	public static void main(String[] args) {
		
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
	   WebDriver driver= new ChromeDriver();
	   
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://ui.freecrm.com/");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("baiyasshubham@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Mahol@1234");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		
		
		// xpath= //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]
		//xpath= //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[4]/td[2]
		
		// Method 1
		String before_xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
		String after_xpath="]/td[2]";
		for(int i=3;i<=5;i++)
		{
			String name=driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if(name.equals("Akshay bhagat")) {
				//checkbox_xpath= //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[4]/td[1]/div
				driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" +i+ "]/td[1]/div")).click();
			}
		}
		
		
		// Method 2
		
		driver.findElement(By.xpath("//td[text()='pooja  patil']//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
		driver.findElement(By.xpath("//td[text()='shubham pradip baiyas']//preceding-sibling::td//div[@class='ui fitted read-only checkbox']")).click();
		driver.findElement(By.xpath("//td[text()='Akshay bhagat']//preceding-sibling::td[@class='']//div[@class='ui fitted read-only checkbox']")).click();
	}

}
//*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]