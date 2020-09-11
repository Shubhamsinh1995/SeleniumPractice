package seleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUp_handle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://www.popuptest.com/");
		driver.findElement(By.partialLinkText("Click here")).click();
		//driver.findElement(By.xpath("//a[@class='black']")).click();
		driver.findElement(By.linkText("Good PopUp #1")).click();
		Set<String> handler= driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String parentwindow=it.next();
		System.out.println(" Parent window id "+parentwindow);
		
		
		String childwindow=it.next();
		System.out.println(" Parent window id "+childwindow);
		
		driver.switchTo().window(childwindow);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentwindow);
		System.out.println(driver.getTitle());
	}

}
