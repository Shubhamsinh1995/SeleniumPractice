package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropDown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
	// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@role='button' and @id='u_0_2']")).click();
		
		WebElement day=driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		
		/*Select select1=new Select(day);
		select1.selectByVisibleText("2");

		Select select2=new Select(month);
		select2.selectByVisibleText("Apr");
	//	select2.selectByIndex(4); 

		Select select3=new Select(year);
		select3.selectByVisibleText("1995"); */
		
		String dob="2-Apr-1995";
		String str[]=dob.split("-");
		
		SelectValueFromDropDown(day,str[0]);
		SelectValueFromDropDown(month,str[1]);
		SelectValueFromDropDown(year,str[2]);
		
		
		//SelectValueFromDropDown(day,"2");
	//	SelectValueFromDropDown(month,"Apr");
	//	SelectValueFromDropDown(year,"1995");
		
	}
	 
	public static void SelectValueFromDropDown(WebElement element, String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	
	
	

}
