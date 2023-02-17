package com.phptravelsBaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClassAdminlogin extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//input[@type='text'][@name='email']")
	private WebElement adminUser;
	@FindBy(xpath="//input[@type='password'][@name='password']")
	private WebElement adminPass;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement admLogBtn;
	public TestClassAdminlogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		adminURL();
	}
	public void enterAdminUname(String AdUname) {
		adminUser.sendKeys(AdUname);
	}
	public void enterAdminPass(String AdPass) {
		adminPass.sendKeys(AdPass);
	}
	public void clkLog() {
		admLogBtn.click();
	}
	public String clkAdmLogin() {
		admLogBtn.click();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
		String actualTitle=driver.getTitle();
		return actualTitle;
		
	}
	
	
	

}
