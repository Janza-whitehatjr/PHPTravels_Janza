package com.phptravelsBaseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestClasspayment extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//a[@href='https://phptravels.net/account/add_funds' and @class=' waves-effect']")
	private WebElement addFunds;
	@FindBy(xpath="//input[contains(@id,'gateway_paypal')]")
	private WebElement paypalradio;
	@FindBy(xpath="//button[@type='submit'][text()='Pay Now ']")
	private WebElement paymentBtn;
	
	
	
	public TestClasspayment(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		customerURL();
	}
	public void clkFunds() {
		addFunds.click();
	}

	public void selectpaypal() {
		paypalradio.click();
	}
	public void clkPayment() {
		paymentBtn.click();
	}
}
