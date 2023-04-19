package com.in.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.in.base.TestBase;
import com.in.pageObjects.AccountPage;
import com.in.pageObjects.CustomerPage;
import com.in.pageObjects.HomePage;
import com.in.utilities.JDBCDatabaseUtilities;

public class AccountTest extends TestBase {
	
	public WebDriver driver;
	
	public AccountTest() {
		super();
	}
	
	HomePage homePage;
	CustomerPage customerPage;
	AccountPage accountPage;
	JDBCDatabaseUtilities DatabaseUtilities=new JDBCDatabaseUtilities();
	
	@BeforeClass
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
		customerPage=homePage.clickCustomerLoginBtn();
		accountPage=customerPage.customerLogin();
		accountPage.selectAccountNoDD();
		
	}

	
	@Test(dataProvider = "transactionTestData")
	public void currentBalance(String amount, String transactionType, String currentBalance) {
		accountPage.depositAndWithdrawlAmount(amount, transactionType);
		accountPage.fnVerifyCurrentBalance(currentBalance);
	}
	
	@DataProvider(name = "transactionTestData")
	public Object[][] deleteCustomerData() {

		String[][] data=DatabaseUtilities.testData("select * from transaction;");
		return data;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
