package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFund {
	
	WebDriver driver;
	public TransferFund(WebDriver driver) {
		this.driver = driver;
	}
	
	By linkTransferFunds = By.linkText("Transfer Funds");
	By textTransferFunds = By.xpath("//h1[text()='Transfer Funds']");
	By textBoxAmounts = By.id("amount");
	By btnTransfer = By.xpath("//input[@value='Transfer']");
	By textTransferComplete = By.xpath("//h1[text()='Transfer Complete!']");
	By drpdwnToAccountID = By.id("toAccountId");
	By drpdwnFromAccountID = By.id("fromAccountId");
	
	public boolean fundTransfer() throws InterruptedException {
		boolean result = false;
		//Navigate to Transfer Funds link
		driver.findElement(linkTransferFunds).click();
		Thread.sleep(5000);
		
		//Enter the amount to be transfered
		driver.findElement(textBoxAmounts).sendKeys("100");
		
		//Validate Account ID, transfer fund and validate the success message
		if (validateFromAndToAccounts()) {
			driver.findElement(btnTransfer).click();
			WebElement message = driver.findElement(textTransferComplete);
			if (message.isDisplayed()) {
				System.out.println("Message displayed is: "+ message.getText());
			}
			
			result = true;
		}
		
		return result;
	}
	
	public boolean validateFromAndToAccounts() {
		boolean isValid = true;
		String fromAccount = driver.findElement(drpdwnFromAccountID).getText();
		String toAccount = driver.findElement(drpdwnToAccountID).getText();
		if (fromAccount == "" || toAccount == "") {
			isValid = false;
		}
		
		return isValid;
	}
}
