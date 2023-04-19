package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.in.base.TestBase;

public class AddCustomer extends TestBase {
	
	WebDriver driver;
	
	public AddCustomer(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()='First Name :']//following-sibling::input")
	private WebElement first_name_edt;
	
	@FindBy(xpath = "//*[text()='Last Name :']//following-sibling::input")
	private WebElement last_name_edt;
	
	@FindBy(xpath = "//*[text()='Post Code :']//following-sibling::input")
	private WebElement post_code_edt;
	
	@FindBy(xpath = "//*[@class='btn btn-default']")
	private WebElement add_customer_btn;
	
	public void fillFirstName(String firstNameTxt) {
		input(driver, first_name_edt, firstNameTxt);
	}
	
	public void fillLastName(String lastNameTxt) {
		input(driver, last_name_edt, lastNameTxt);
	}
	
	public void fillPostCode(String postCodeTxt) {
		input(driver, post_code_edt, postCodeTxt);
	}
	
	public void clickAddCustomer() {
		click(driver, add_customer_btn);
	}
	
	public void addCustomer(String firstNameTxt, String lastNameTxt, String postCodeTxt) {
		fillFirstName(firstNameTxt);
		fillLastName(lastNameTxt);
		fillPostCode(postCodeTxt);
		clickAddCustomer();
		clickAlert(driver);
	}

}
