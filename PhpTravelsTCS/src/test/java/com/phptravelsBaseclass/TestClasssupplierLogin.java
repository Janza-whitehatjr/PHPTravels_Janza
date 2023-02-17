package com.phptravelsBaseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClasssupplierLogin extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//input[@type='text'][@name='email']")
	private WebElement supUsername;
	@FindBy(xpath="//input[@type='password'][@name='password']")
	private WebElement supPassword;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement suplogBtn;
	
	public TestClasssupplierLogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		supplierURL();
	}
	
	public void enterUser(String username) {
		supUsername.sendKeys(username);
	}
	public void enterPswd(String Pswd) {
		supPassword.sendKeys(Pswd);
	}
	public void Login() {
		suplogBtn.click();
	}
	public String clkSupLogin() {
		suplogBtn.click();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
		String actualTitle=driver.getTitle();
		return actualTitle;
	}

}
