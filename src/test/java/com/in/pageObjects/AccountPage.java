package com.in.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.in.base.TestBase;

public class AccountPage extends TestBase {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "accountSelect")
	private WebElement account_number_DD;
	
	@FindBy(xpath = "//*[contains(text(),'Transactions')]")
	private WebElement transactions_btn;
	
	@FindBy(xpath = "//*[contains(text(),'Deposit')]")
	private WebElement deposit_btn;
	
	
	@FindBy(xpath = "//*[contains(text(),'Withdrawl')]")
	private WebElement withdrawl_btn;
	
	@FindBy(xpath = "//*[contains(text(),'Account Number')]/strong[2]")
	private WebElement balance_amount_label;
	
	@FindBy(xpath = "//*[@class='btn btn-default']")
	private WebElement deposit_withdrawl_btn;
	
	@FindBy(xpath = "//*[@ng-model='amount']")
	private WebElement amount_edt;
	
	
	
	public void selectAccountNoDD() {
		selectValue(account_number_DD, "1003");
	}
	
	public void clickDepositBtn() {
		click(driver, deposit_btn);
	}
	
	public void clicWithdrawlBtn() {
		click(driver, withdrawl_btn);
	}
	
	public void fillAmount(String amount) {
		input(driver, amount_edt, amount);
	}
	
	public void clickDepositWithdrawlBtn() {
		click(driver, deposit_withdrawl_btn);
	}
	
	public void depositAmount(String amount) {
		clickDepositBtn();
		fillAmount(amount);
		clickDepositWithdrawlBtn();
	}
	
	public void withdrawltAmount(String amount) {
		clicWithdrawlBtn();
		fillAmount(amount);
		clickDepositWithdrawlBtn();
	}
	
	public void depositAndWithdrawlAmount(String amount, String transactionType) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(transactionType.equalsIgnoreCase("Credit")) {
			clickDepositBtn();
		}else if (transactionType.equalsIgnoreCase("Debit")) {
			clicWithdrawlBtn();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fillAmount(amount);
		clickDepositWithdrawlBtn();
	}
	
	public void fnVerifyCurrentBalance(String expectedAmount) {
		if(Integer.parseInt(expectedAmount) == Integer.parseInt(balance_amount_label.getText())) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false, "Expected amount is not equal to actual amount");
		}
		
	}

}
