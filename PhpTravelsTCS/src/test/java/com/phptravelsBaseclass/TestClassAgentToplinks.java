package com.phptravelsBaseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestClassAgentToplinks extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//a[contains(@title,'hotels')]")
	private WebElement linkHotel;
	@FindBy(xpath="//a[text()='Tours']")
	private WebElement linkTours;
	@FindBy(xpath="//a[text()='flights']")
	private WebElement linkFlights;
	@FindBy(xpath="//a[text()='Transfers']")
	private WebElement linkTransfers;
	@FindBy(xpath="//a[text()='visa']")
	private WebElement linkVisa;
	@FindBy(xpath="//a[text()='Blog']")
	private WebElement linkBlog;
	@FindBy(xpath="//a[text()='Offers']")
	private WebElement linkOffers;
	/*@FindBy(xpath="")
	private WebElement linkompany;*/
	public TestClassAgentToplinks(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		customerURL();
	}
	public void clkHotel() {
		linkHotel.click();
	}
	public void clkfights() {
		linkFlights.click();
	}
	public void clkTours() {
		linkTours.click();
		
	}
	public void clkTransfers() {
		linkTransfers.click();
	}
	public void clkVisa() {
		linkVisa.click();
	}
	public void clkBlog() {
		linkBlog.click();
	}
	public void clkOffers() {
		linkOffers.click();
	}







}
