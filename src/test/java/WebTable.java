
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable {

	WebDriver driver = new ChromeDriver();

	@Test
	public void handleWebTable() {
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		// Finding headers and print
		List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@id='customers']//tbody//th"));
		System.out.println("Hearders count is: " + allHeaders.size());

		for (WebElement header : allHeaders) {
			System.out.println(header.getText());
		}

		// Find rows and print
		List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
		System.out.println("Number of rows are: " + numberOfRows.size());

		for (WebElement rows : numberOfRows) {
			System.out.println(rows.getText());
		}

		// Find specific data and print
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tbody//tr[5]//td[1]"));
		System.out.println(data.getText());

		driver.quit();
	}
}
