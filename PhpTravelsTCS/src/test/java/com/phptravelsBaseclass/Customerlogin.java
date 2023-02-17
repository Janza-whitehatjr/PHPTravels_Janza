package com.phptravelsBaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customerlogin extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//input[@type='email'][@placeholder='Email']")
	private WebElement userName;
	@FindBy(xpath="//input[@type='password'][@placeholder='Password']")
	private WebElement password;
	@FindBy(xpath="//span[text()=\"Login\"]")
	private WebElement loginBtn;
	
	public Customerlogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		customerURL();
		
	}
	public void setUserName(String UserName) {
		userName.sendKeys(UserName);
	}
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	public String validLogin() {
		loginBtn.click();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='tester']")));
		String actualTitle=driver.getTitle();
		return actualTitle;
	}
	public void clruserName() {
		userName.clear();
	}
	public void clrPassword() {
		password.clear();
	}
	

}
