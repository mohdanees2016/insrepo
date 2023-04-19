package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.in.base.TestBase;

public class HomePage extends TestBase{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='Customer Login']")
	private WebElement customer_login_btn;
	
	@FindBy(xpath = "//*[text()='Bank Manager Login']")
	private WebElement bank_manager_login_btn;
	
	public CustomerPage clickCustomerLoginBtn() {
		click(driver, customer_login_btn);
		return new CustomerPage(driver);
	}
	
	public ManagerPage clickBankManagerLoginBtn() {
		click(driver, bank_manager_login_btn);
		return new ManagerPage(driver);
	}

}
