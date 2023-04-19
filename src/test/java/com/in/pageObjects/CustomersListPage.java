package com.in.pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.in.base.TestBase;

public class CustomersListPage extends TestBase{

	WebDriver driver;
	
	public CustomersListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@ng-model='searchCustomer']")
	private WebElement search_customer_edt;
	
	@FindBy(xpath = "//*[@class='table table-bordered table-striped']/tbody/tr")
	private List<WebElement> customer_table_total_row_cnt;
	
	@FindBy(xpath = "//*[@class='table table-bordered table-striped']/tbody/tr[1]/td")
	private List<WebElement> customer_table_total_column_cnt;
	
	@FindBy(xpath = "//*[@class='table table-bordered table-striped']/tbody/tr/td[5]")
	private WebElement delete_btn;
	
	public void fillSearchCustomer(String firstNameTxt) {
		input(driver, search_customer_edt, firstNameTxt);
	}
	
	public void clickDeleteCustomerBtn() {
		int s=customer_table_total_row_cnt.size();
		if(s>0) {
			click(driver, delete_btn);
		}	
	}
	
	public void deleteCustomer(String firstNameTxt) {
		fillSearchCustomer(firstNameTxt);
		clickDeleteCustomerBtn();
	}
	
	
	public void fnVerifyCustomerAddedSuccessfully(String firstName, String lastName, String postCode) {
		boolean flag=false;
		fillSearchCustomer(firstName);
		if(iselementsCount(customer_table_total_row_cnt)) {
			int customerTableRowCount=customer_table_total_row_cnt.size();
			for(int i=1;i<=customerTableRowCount;i++) {
			String actFirstName=driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[1]")).getText();
			String actLastName=driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[2]")).getText();
			String actPostCode=driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[3]")).getText();
				if(actFirstName.equalsIgnoreCase(firstName) && actLastName.equalsIgnoreCase(lastName) && actPostCode.equalsIgnoreCase(postCode)) {
					flag=true;
					break;
				}
			}
		}
		Assert.assertTrue(flag, firstName + " "+ "lastName "+ "Customer is not added successfully");
		
	}
	
	public void deleteCustomerSuccessfully(String firstName, String lastName, String postCode) {
		fillSearchCustomer(firstName);
		if(iselementsCount(customer_table_total_row_cnt)) {
			int customerTableRowCount=customer_table_total_row_cnt.size();
			for(int i=1;i<=customerTableRowCount;i++) {
			String actFirstName=driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[1]")).getText();
			String actLastName=driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[2]")).getText();
			String actPostCode=driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[3]")).getText();
				if(actFirstName.equalsIgnoreCase(firstName) && actLastName.equalsIgnoreCase(lastName) && actPostCode.equalsIgnoreCase(postCode)) {
					driver.findElement(By.xpath("//*[@class='table table-bordered table-striped']/tbody/tr["+i+"]/td[5]/button")).click();
					break;
				}
			}
		}
		
	}

}
