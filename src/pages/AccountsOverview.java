package pages;

import org.openqa.selenium.By;

public class AccountsOverview {
	
	By linkAccountNumber = By.xpath("//table[@id='accountTable']//a[contains(@href,'id')]");
	By linkAccountsOverview = By.linkText("Accounts Overview");
	By tbAccountsOverview = By.xpath("//table[@id='accountTable']");
	By textAccountActivity = By.xpath("//*[text()='Account Activity']");
	By drpdwnMonth = By.xpath("//select[@id='month']");
	By drpdwnType = By.xpath("//select[@id='transactionType']");
	By btnGo = By.xpath("//input[@value='Go']");
	By tbTransactionTable = By.xpath("//table[@id='transactionTable']");
	
	
}
