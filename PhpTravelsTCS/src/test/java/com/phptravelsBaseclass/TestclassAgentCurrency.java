package com.phptravelsBaseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestclassAgentCurrency extends TestBase{
	WebDriver driver;
	@FindBy(xpath="//button[@type='button'][@id='currency']")
	private WebElement USD;
	@FindBy(xpath="//a[text()=' INR']")
	private WebElement SelectINR;
	public TestclassAgentCurrency(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		customerURL();
	}
	public void clkUSD() {
		USD.click();
	}
	public void clkINR() {
		SelectINR.click();
	}

}
