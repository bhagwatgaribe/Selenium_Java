import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Screenshot {

	WebDriver driver=new ChromeDriver();
	@Test
	public void takeScreenshot() {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Call getScreenshotAs method to create an image file
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String path = ".\\Screenshot\\screenshot.png";
		// Define destination file
		File destFile = new File(path);

		try {
			// Copy the screenshot to the destination file
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
