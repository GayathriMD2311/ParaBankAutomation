package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;
	
	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\941081\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		return driver;
	}
	
	public void quitDriver() {
		driver.quit();
	}
}
