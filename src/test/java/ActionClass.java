import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass {

	WebDriver driver;

	@Test
	public void moveToElement() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement lnkAccept = driver.findElement(By.linkText("Accept"));

		Actions action = new Actions(driver);
		
		action.moveToElement(lnkAccept).build().perform();
		
		driver.quit();
	}
	
	@Test
	public void dragAndDropTest() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement eleDraggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement eleDroppable = driver.findElement(By.xpath("//div[@id='droppable'][1]"));

		Actions action = new Actions(driver);
		
		action.dragAndDrop(eleDraggable, eleDroppable).build().perform();
		
		driver.quit();
	}
	
	@Test
	public void click() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement lnkAccept = driver.findElement(By.linkText("Accept"));

		Actions action = new Actions(driver);
		
		action.click(lnkAccept).build().perform();
		
		driver.quit();
	}
	
	@Test
	public void doubleClick() {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement eleDraggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		Actions action = new Actions(driver);
		
		action.contextClick(eleDraggable).build().perform();
		driver.quit();
	}
}
