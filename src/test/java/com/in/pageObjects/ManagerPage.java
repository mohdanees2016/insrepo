package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.in.base.TestBase;

public class ManagerPage extends TestBase{

	WebDriver driver;
	
	public ManagerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(),'Add Customer')]")
	private WebElement add_customer_btn;
	
	@FindBy(xpath = "//*[contains(text(),'Open Account')]")
	private WebElement open_account_btn;
	
	@FindBy(xpath = "//*[contains(text(),'Customers')]")
	private WebElement customers_btn;
	
	public AddCustomer clickAddCustomersBtn() {
		click(driver, add_customer_btn);
		return new AddCustomer(driver);
	}
	
	public void clickOpenAccountBtn() {
		click(driver, open_account_btn);
	}
	
	public CustomersListPage clickCustomersBtn() {
		click(driver, customers_btn);
		return new CustomersListPage(driver);
	}
	
}
