package seleniumPractice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {


	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
	// implicitly Wait:-> is always applied globally --- available for all the elements on the webpage
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        com.google.common.io.Files.copy(src,new File("./ScreenShots/facebook.png"));

		driver.quit();
   
	}

}
 