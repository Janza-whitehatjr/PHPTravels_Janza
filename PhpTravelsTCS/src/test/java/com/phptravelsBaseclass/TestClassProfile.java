package com.phptravelsBaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClassProfile extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//a[@href='https://phptravels.net/account/profile' and @class=' waves-effect']")
	private WebElement myProfile;
	@FindBy(xpath="//input[contains(@name,'address1')]")
	private WebElement addressInput;
	
	public TestClassProfile(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		customerURL();
	}
	public void clkProfile() {
		myProfile.click();
	}
	public void clrAddress() {
		addressInput.clear();
	}
	public void enterAddress(String address){
		addressInput.sendKeys(address);
		
	}
	public String getResult() {
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'address1')]")));
		String actualText=addressInput.getAttribute("value");
		return actualText;
	}
	

}
