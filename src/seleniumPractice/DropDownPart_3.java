package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownPart_3 {
	
    static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
	// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
	//	WebElement day=driver.findElement(By.id("day"));
	//	WebElement month=driver.findElement(By.id("month"));
	//	WebElement year=driver.findElement(By.id("year"));
		
		
	// here we select perticular drop down value without using select class	
	//	List<WebElement> monthList=driver.findElements(By.xpath("//select[@id='month']//option"));
	//	System.out.println(monthList.size());

		/*for(int i=0;i<monthList.size();i++) {
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals("May")) {
				monthList.get(i).click();
				break;
			}
		}*/
		
		
		String momth_Xpath="//select[@id='month']//option";
		
		selectValuefromDropDown(momth_Xpath, "Apr");
	}
	
	public static void selectValuefromDropDown(String xPath, String value) {
		
		List<WebElement> monthList=driver.findElements(By.xpath(xPath));
		System.out.println(monthList.size());
		for(int i=0;i<monthList.size();i++) {
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals("value")) {
				monthList.get(i).click();
				break;
			}
		}
	}
	
	
	

}
