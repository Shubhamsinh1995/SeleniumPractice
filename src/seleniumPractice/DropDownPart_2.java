package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPart_2 {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
	// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		WebElement day=driver.findElement(By.id("day"));
		WebElement month=driver.findElement(By.id("month"));
		WebElement year=driver.findElement(By.id("year"));
		
		Select select=new Select(day);
		select.selectByVisibleText("2");
		
		System.out.println(select.isMultiple());
		
		List<WebElement> listdays=select.getOptions();
		System.out.println(listdays.size());
		int totaldays=listdays.size()-1;
		System.out.println("total days are: "+ totaldays);
		
		for(int i=0;i<listdays.size();i++) {
			String dayVal=listdays.get(i).getText();
			System.out.println(dayVal);
			if(dayVal.equals("20")) {
				listdays.get(i).click();
				break ;
			}
		}

	}

}
