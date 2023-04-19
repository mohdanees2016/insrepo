package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.in.base.TestBase;

public class CustomerPage extends TestBase {
	WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@ng-model='searchCustomer']")
	private WebElement search_customer_edt;
	
	@FindBy(xpath = "//*[contains(text(),'Your Name :')]/parent::div//select")
	private WebElement your_name_dd;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement login_btn;
	
	public void selectCustomerDDValue() {
		selectValue(your_name_dd, "Hermoine Granger");
	}
	
	public void clickCustomerLoginBtn() {
		click(driver, login_btn);
	}
	
	public AccountPage customerLogin() {
		selectCustomerDDValue();
		clickCustomerLoginBtn();
		return new AccountPage(driver);
	}
	
	
	
}
