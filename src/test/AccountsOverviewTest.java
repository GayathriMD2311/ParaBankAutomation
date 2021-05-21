package test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AccountsOverview;
import pages.Base;
import pages.LoginPage;
import pages.TransferFund;

public class AccountsOverviewTest extends Base {

		@BeforeClass
		public void initialize( ) {
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
		
		//Validate Accounts Overview
		@Test
		public void accountsOverview() throws InterruptedException {
			AccountsOverview accountsOverview = new AccountsOverview(driver);
			
			Assert.assertTrue(accountsOverview.validateAccountActivity("January", "All"));
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}


}
