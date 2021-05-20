package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AccountsOverview;
import pages.Base;
import pages.LoginPage;
import pages.TransferFund;

public class AccountsOverviewTest extends Base {

		@BeforeSuite
		public void openBrowser( ) {
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
		public void transferFunds() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			AccountsOverview accountsOverview = new AccountsOverview(driver);
			boolean value = accountsOverview.();
			
			Assert.assertTrue(value, "Fund transfer failed");
			
		}
		
		@AfterSuite
		public void quit() {
			quitDriver();
		}


}
