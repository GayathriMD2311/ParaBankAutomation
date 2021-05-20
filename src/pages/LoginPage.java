package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By textBoxUserName = By.name("username");
	By textBoxPassword = By.name("password");
	By btnLogin = By.xpath("//input[@value='Log In']");
	By textAccountsOverview = By.xpath("//h1[text()='Accounts Overview']");
	
	public boolean loginApplication(String username, String password) {
		driver.findElement(textBoxUserName).sendKeys(username);
		driver.findElement(textBoxPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
		
		return driver.findElement(textAccountsOverview).isDisplayed();
	}
}
