package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		System.out.println(driver.getTitle());
		
//		List<WebElement> radio= driver.findElements(By.xpath("//input[@type='radio']"));
//		
//		for(int i=0;i<radio.size();i++) 
//		{
//			WebElement ele=radio.get(i);
//			int x=ele.getLocation().getX();
//			if(x!=0) 
//			{
//				ele.click();
//				break;
//			}
//		}
		
		List<WebElement> radio=driver.findElements(By.xpath("//input[@name='lang']"));
				for(int i=0;i<radio.size();i++)
				{
					WebElement localR=radio.get(i);
					String value=localR.getAttribute("value");
					if(value.equalsIgnoreCase("java"))
					{
						localR.click();
					}
				}
				
				driver.quit();
	}

}
