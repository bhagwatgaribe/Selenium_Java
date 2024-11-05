import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	WebDriver driver = new ChromeDriver();
	Workbook workbook;
	Sheet sheet;
	Cell cell1;
	FileOutputStream fileOut;

	@Test(dataProvider = "loginData")
	public void ddTestForSearchIteam(String username, String password) {
		driver.get("http://localhost/opencart/upload/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		WebElement _useremail = driver.findElement(By.xpath("//input[@id='input-email']"));
		WebElement _userPassword = driver.findElement(By.xpath("//input[@id='input-password']"));
		WebElement _btnLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

		_useremail.sendKeys(username);
		_userPassword.sendKeys(password);
		_btnLogin.click();

		driver.quit();

	}

	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {
		String excelFilePath = ".\\testData\\TestData.xlsx"; // Path to your Excel file
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		workbook = new XSSFWorkbook(inputStream);

		Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
		int rowCount = sheet.getLastRowNum() + 1; // Get number of rows (including header if needed)

		Object[][] data = new Object[rowCount][2]; // Assuming 2 columns: username, password

		// Loop through the rows to fetch data
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			data[i][0] = row.getCell(0).getStringCellValue(); // Username
			data[i][1] = row.getCell(1).getStringCellValue(); // Password
		}

		workbook.close(); // Close the workbook after use
		inputStream.close(); // Close the file input stream
		return data;
	}
}
