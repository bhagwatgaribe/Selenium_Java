
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {

	WebDriver driver = new ChromeDriver();

	@Test
	public void selectDropdown() {
		driver.get("https://www.w3schools.com/howto/howto_custom_select.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement carDropDown = driver.findElement(By.xpath("//div[@class='w3-col m6']/select[1]"));

		Select select = new Select(carDropDown);

		select.selectByIndex(3);
		select.selectByValue("1");
		select.selectByVisibleText("Audi");

		driver.quit();
	}

	@Test
	public void getAllOptions() {
		driver.get("https://www.w3schools.com/howto/howto_custom_select.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement carCustomDropDown = driver.findElement(By.xpath("//div[@class='custom-select']/div//child::div"));

		Select select = new Select(carCustomDropDown);
		List<WebElement> allOptions = select.getOptions();
		
		for(WebElement options : allOptions) {
			System.out.println(options.getText());
		}
		
		driver.quit();
	}
}
