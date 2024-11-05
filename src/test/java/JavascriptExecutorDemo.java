import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavascriptExecutorDemo {

	WebDriver driver = new ChromeDriver();

	@Test
	public void javaScript() throws InterruptedException {
		driver.get("https://www.w3schools.com/html/default.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement element = driver
				.findElement(By.xpath("//div[@class='footerlinks_2']/h5[contains(text(),'Top Tutorials')]"));

		// Scroll the page until the element is in view
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// Send text

		WebElement txtSearch = driver.findElement(By.xpath("//input[@id='tnb-google-search-input']"));
		js.executeScript("arguments[0].value='Java';", txtSearch);

		Thread.sleep(3000);

		driver.quit();
	}
}
