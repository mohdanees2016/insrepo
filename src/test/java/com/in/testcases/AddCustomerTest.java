package com.in.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.in.base.TestBase;
import com.in.pageObjects.AddCustomer;
import com.in.pageObjects.CustomerPage;
import com.in.pageObjects.CustomersListPage;
import com.in.pageObjects.HomePage;
import com.in.pageObjects.ManagerPage;
import com.in.utilities.JDBCDatabaseUtilities;

public class AddCustomerTest extends TestBase {
	
	public WebDriver driver;
	
	HomePage homePage;
	ManagerPage managerPage;
	AddCustomer addCustomer;
	CustomerPage customerPage;
	CustomersListPage customerListPage;
	JDBCDatabaseUtilities DatabaseUtilities=new JDBCDatabaseUtilities();
	
	
	public AddCustomerTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homePage = new HomePage(driver);
		managerPage=homePage.clickBankManagerLoginBtn();
		addCustomer=managerPage.clickAddCustomersBtn();
	}
	
	@Test(dataProvider = "addCustomerTestData",priority = 1)
	public void addCustomer(String firstName, String lastName, String postCode) {
		addCustomer=managerPage.clickAddCustomersBtn();
		addCustomer.addCustomer(firstName, lastName, postCode);
		
		customerListPage=managerPage.clickCustomersBtn();
		customerListPage.fnVerifyCustomerAddedSuccessfully(firstName, lastName, postCode);
		
	}
	
	@Test(dataProvider = "deleteCustomerTestData",priority = 2)
	public void deleteCustomer(String firstName, String lastName, String postCode) {
		customerListPage=managerPage.clickCustomersBtn();
		customerListPage.deleteCustomerSuccessfully(firstName, lastName, postCode);
	}
	
	@DataProvider(name = "addCustomerTestData")
	public Object[][] addCustomerData() {

		String[][] data=DatabaseUtilities.testData("select * from add_customer;");
		return data;
	}
	
	@DataProvider(name = "deleteCustomerTestData")
	public Object[][] deleteCustomerData() {

		String[][] data=DatabaseUtilities.testData("select * from delete_customer;");
		return data;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
