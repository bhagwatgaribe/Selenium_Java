import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {

	WebDriver driver = new ChromeDriver();

	@Test
	public void validateBrokenLinks() throws IOException {
		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Loop through all links and verify if they are broken
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Skip if the URL is empty or null
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			// Check if the link is valid or broken
			verifyLink(url);
		}
		
		driver.quit();
	}

	public void verifyLink(String urlLink) throws IOException {
		try {
			// Create a URL object
			URL url = new URL(urlLink);

			// Open a connection and set the timeout
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);

			// Connect and get the response code
			httpURLConnection.connect();
			int responseCode = httpURLConnection.getResponseCode();

			if (responseCode >= 400) {
				System.out.println(urlLink + " is a broken link. Response Code: " + responseCode);
			} else {
				System.out.println(urlLink + " is a valid link. Response Code: " + responseCode);
			}

		} catch (Exception e) {
			System.out.println(urlLink + " is a broken link. Exception: " + e.getMessage());
		}
	}
}
