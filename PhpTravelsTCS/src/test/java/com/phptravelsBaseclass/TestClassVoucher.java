package com.phptravelsBaseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestClassVoucher extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//a[@href='https://phptravels.net/account/bookings'][@class=' waves-effect']")
	private WebElement bookings;
	@FindBy(xpath="//a[text()=\" View Voucher\"]")
	private WebElement viewVoucher;
	
	public TestClassVoucher(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		customerURL();
	}
	public void Bookings() {

	    bookings.click();
	}
	public void clkVoucher() {
		viewVoucher.click();
	}

}
