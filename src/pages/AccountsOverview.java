package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.Common;

public class AccountsOverview {
	public WebDriver driver;
	public Select dropDown;

	By linkAccountNumber = By.xpath("//table[@id='accountTable']//a[contains(@href,'id')][1]");
	public By linkAccountsOverview = By.linkText("Accounts Overview");
	By tbAccountsOverview = By.xpath("//table[@id='accountTable']");
	By textAccountActivity = By.xpath("//*[text()='Account Activity']");
	By drpdwnMonth = By.xpath("//select[@id='month']");
	By drpdwnType = By.xpath("//select[@id='transactionType']");
	By btnGo = By.xpath("//input[@value='Go']");
	By tbTransactionTableRows = By.xpath("//table[@id='transactionTable']//tr");
	By textNoTransactions = By.xpath("//*[text()='No transactions found.']");

	public AccountsOverview(WebDriver driver) {
		this.driver = driver;
	}

	public boolean validateAccountActivity(String period, String type) throws InterruptedException {
		driver.findElement(linkAccountsOverview).click();
		boolean result = false;
		if(driver.findElement(tbAccountsOverview).isDisplayed()) {
			Common.click(driver.findElement(linkAccountNumber));
			
			if (driver.findElement(textAccountActivity).isDisplayed()){
				WebElement goButton = driver.findElement(btnGo);
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", goButton);
				
				dropDown = new Select(driver.findElement(drpdwnMonth));
				dropDown.selectByVisibleText(period);
				
				dropDown = new Select(driver.findElement(drpdwnType));
				dropDown.selectByVisibleText(type);
						
				Common.click(driver.findElement(btnGo));
				
				if(driver.findElements(tbTransactionTableRows).size() > 1) {
					result = true;
				} else {
					result = driver.findElement(textNoTransactions).isDisplayed();
				}
			}
		}
		
		return result;
	}

}
