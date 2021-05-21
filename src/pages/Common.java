package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	public static WebDriver driver;
	public static void waitForDisplayed(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static List<WebElement> getAllOptionsInDropDownList(WebElement value) {
		Select dropDown = new Select(value);
		List<WebElement> ls = dropDown.getOptions();
		
		return ls;
	}
	
	public static void click(WebElement element) {
		if (element.isDisplayed()) {
			element.click();
		}
	}
}
