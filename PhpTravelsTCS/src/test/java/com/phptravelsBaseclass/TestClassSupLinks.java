package com.phptravelsBaseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestClassSupLinks extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//a[contains(@data-bs-target,'#toursmodule')]")
	private WebElement Tours;
	@FindBy(xpath="//a[contains(@data-bs-target,'#Tours')]")
	private WebElement toursInside;
	@FindBy(xpath="//a[text()='Manage Tours']")
	private WebElement manageTours;
	@FindBy(xpath="//a[contains(@href,'https://phptravels.net/api/supplier/tours/extras')]")
	private WebElement ToursExtras;
	@FindBy(xpath="//small[text()='Tours Management']")
	private WebElement manageInside;
	
	@FindBy(xpath="//div[text()='Extras Management']")
	private WebElement extrasInside;
	
	@FindBy(xpath="//a[contains(@class,'loadeffect nav-link collapsed mdc-ripple-upgraded')]")
	private WebElement bookings;
	
	
	public TestClassSupLinks(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		supplierURL();
	}
	
	public void clkTours() {
		Tours.click();
	}
	public void clkToursinside() {
		toursInside.click();
	}
	public String clkManageTours() {
		manageTours.click();
		String managetours=manageInside.getText();
		return managetours;
	}
	public String clkToursextras() {
		ToursExtras.click();
		String toursextras=extrasInside.getText();
		return toursextras;
	}
	
	public void clkBookings() {
		bookings.click();
	}
	
	

}
