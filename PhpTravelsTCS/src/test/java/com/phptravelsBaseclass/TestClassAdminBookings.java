package com.phptravelsBaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClassAdminBookings extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//a[@class='nav-link loadeffect']")
	private WebElement Bookings;
	@FindBy(xpath="//div[text()='Pending Bookings']")
	private WebElement PendingBookings;
	@FindBy(xpath="//select[@id='booking_status']")
	private WebElement selectStatus;
	@FindBy(xpath="//option[text()='Confirmed']")
	private WebElement selectconfirm;
	@FindBy(xpath="//div[text()='Cancelled Bookings']")
	private WebElement BookingCancelled;
	@FindBy(xpath="//button[contains(@class,'btn btn-danger mdc-ripple-upgraded')]")
	private WebElement cancelBtn;
	@FindBy(xpath="//div[text()='Cancelled Bookings']//preceding::div[1]")
	private WebElement cancelledCount;
	@FindBy(xpath="//div[contains(text(),'Confrimed Bookings')]//preceding::div[1]")
	private WebElement confirmCount;
	@FindBy(xpath="//div[contains(text(),'Pending Bookings')]//preceding::div[1]")
	private WebElement pendingCount;
	@FindBy(xpath="//a[contains(@class,'btn btn-outline-dark mdc-ripple-upgraded')]")
	private WebElement invoice;
	@FindBy(xpath="//a[text()='Website']")
	private WebElement website; 
	
	
	
	
	
	public TestClassAdminBookings(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		adminURL();
	}
	
	
	
	
	public void clkBookings() {
		Bookings.click();
	}
	public void clkinvoice() {
		invoice.click();
	}
	public void clkpendingBookings() {
		PendingBookings.click();
	}
	public void changeStatus() {
		selectStatus.click();
	}
	public void selectConfirm() {
		selectconfirm.click();
	}
	public void clkBookingCancelled() {
		BookingCancelled.click();
	}
	public void clkCancel() {
		cancelBtn.click();
		
	}
	
	public String cancelcout() {
		String cancelCount=cancelledCount.getText();
		return cancelCount;
	}
	public String Confirmcount() {
		String confirmcount=confirmCount.getText();
		return confirmcount;	
	}
	public String Pendingcount() {
		String pendingcount=pendingCount.getText();
		return pendingcount;
	}
	public void clkwebsite() {
		website.click();
	
	}

}
