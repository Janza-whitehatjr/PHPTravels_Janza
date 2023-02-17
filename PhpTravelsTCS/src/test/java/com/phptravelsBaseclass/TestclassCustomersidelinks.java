package com.phptravelsBaseclass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestclassCustomersidelinks extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//a[@href='https://phptravels.net/account/bookings'][@class=' waves-effect']")
	private WebElement bookings;
	@FindBy(xpath="//a[@href='https://phptravels.net/account/add_funds' and @class=' waves-effect']")
	private WebElement addFunds;
	@FindBy(xpath="//a[@href='https://phptravels.net/account/profile' and @class=' waves-effect']")
	private WebElement myProfile;
	@FindBy(xpath="//a[@href='https://phptravels.net/account/logout' and @class=' waves-effect']")
	private WebElement logout;
	@FindBy(xpath="//h3[text()='My Bookings']")
	private WebElement bookingsinside;
	@FindBy(xpath="//h3[text()='Add Funds']")
	private WebElement fundsinside;
	@FindBy(xpath="//h3[text()='Profile Information']")
	private WebElement profileinside;
	
	public TestclassCustomersidelinks(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		customerURL();
		
	}
	public void Bookings() {

	    bookings.click();
	}
	
	public void clkFunds() {
		addFunds.click();
	}
	public void clkProfile() {
		myProfile.click();
	}
	public void clkLogout() {
		logout.click();
	}
	public String BookingText() {
		String bookingText=bookingsinside.getText();
		return bookingText;
	}
	public String FundsText() {
		String fundsText=fundsinside.getText();
		return fundsText;
	}
	public String ProfileText() {
		String profileText=profileinside.getText();
		return profileText;
	}



}
