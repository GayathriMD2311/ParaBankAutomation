package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TransferFund;
import pages.Base;
import pages.LoginPage;

public class TransferFundsTest extends Base {
	
	@BeforeClass
	public void initialize() {
		driver = initializeDriver();
	}
	
	//Login to the application
	@Parameters({ "URL", "username", "password" })
	@Test
	public void login(String url, String username, String password) {
		driver.get(url);
		LoginPage login = new LoginPage(driver);
		
		Assert.assertTrue(login.loginApplication(username, password));
	}
	
	//Validate Fund Transfer
	@Test
	public void transferFunds() throws InterruptedException {	
		TransferFund transferFund = new TransferFund(driver);
		boolean value = transferFund.fundTransfer();
		
		Assert.assertTrue(value, "Fund transfer failed");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
}
