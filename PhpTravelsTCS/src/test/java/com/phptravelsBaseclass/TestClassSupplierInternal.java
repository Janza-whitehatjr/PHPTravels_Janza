package com.phptravelsBaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClassSupplierInternal extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//div[text()='Sales overview & summary']")
	private WebElement SalesOverview;
	@FindBy(xpath="//div[text()='Pending Bookings']")
	private WebElement PendBook;
	@FindBy(xpath="//div[text()='Confrimed Bookings']")
	private WebElement confirmBook;
	@FindBy(xpath="//div[text()='Confrimed Bookings']//preceding::div[1]")
	private WebElement confirmCount;
	@FindBy(xpath="//div[text()='Pending Bookings']//preceding::div[1]")
	private WebElement PendingCount;
	@FindBy(xpath="//select[contains(@id,'booking_status')]")
	private WebElement selectStatus;
	@FindBy(xpath="//div[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath="//option[text()='Confirmed']")
	private WebElement selectconfirm;
	@FindBy (xpath="//h2[text()='Revenue Breakdown 2023']")
	private WebElement revenue;
	@FindBy(xpath="//canvas[contains(@id,'dashboardBarChart')]")
	private WebElement revenueChart;
	public TestClassSupplierInternal(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		supplierURL();
	}
	
	
	public Boolean displaysales() {
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sales overview & summary']")));
		
		
		if(SalesOverview.isDisplayed()) {
			
			System.out.println("Sales overview and summary is present");
		}
		else {
			System.out.println("Sales overview and summary is not present");
		}
		Boolean salesOverview=SalesOverview.isDisplayed();
		return salesOverview;
	}
	public void clkPending() {
		PendBook.click();
	}
	public void clkstatus() {
		selectStatus.click();
	}
	public void clkconfirm() {
		selectconfirm.click();
	}
	public String Confirmcount() {
		String confirmcount=confirmCount.getText();
		return confirmcount;	
		
	}
	public String Pendingcount() {
		String pendingcount=PendingCount.getText();
		return pendingcount;	
	}
	public void clkDashboard() {
		dashboard.click();
	}
	public Boolean displayRvenue() {
		Boolean Revenue=revenueChart.isDisplayed();
		return Revenue;
	}
	

}
