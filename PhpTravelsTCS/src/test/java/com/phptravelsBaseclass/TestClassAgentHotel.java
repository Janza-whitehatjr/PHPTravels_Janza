package com.phptravelsBaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClassAgentHotel extends TestBase{
	WebDriver driver;
	@FindBy(xpath="//a[contains(@title,'hotels')]")
	private WebElement linkHotel;
	@FindBy(xpath="//span[text()=' Search by City']")
	private WebElement searchCLK; 
	@FindBy(xpath="//input[@type='search'][@class='select2-search__field']")
	private WebElement searchcity;
	@FindBy(xpath="//button[@type='submit'][@id='submit']")
	private WebElement searchBtn;
	public TestClassAgentHotel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		customerURL();
	}
	public void clkHotel() {
		linkHotel.click();
	}
	public void clkSearch() {
		searchCLK.click();
	}
	public void enterCity(String city) {
		searchcity.sendKeys(city);
	}
	public void clksearchBtn() {
		searchBtn.click();
	}
	public void CityName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option']"))).click();
		
	}
	public void SearchBTN() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']"))).click();
		
		
	}

}
