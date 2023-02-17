package com.phptravelsBaseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PHPtravels.customer.CustomerLogin;
import com.phptravelscustomer.utilities.Excelutility;

public class CustomerProfile extends TestBase {
	Customerlogin objLogin;
	TestClassProfile objProfile;
	
	@Test 
	public void login() throws IOException {
		objLogin=new Customerlogin(driver);
		String UserName=Excelutility.getCellData(0, 0);
		String strPassword=Excelutility.getCellData(0, 1);
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
	}
	@Test 
	public void verifyProfile() throws IOException, InterruptedException {
		objProfile=new TestClassProfile(driver);
		Thread.sleep(3000);
		objProfile.clkProfile();
		Thread.sleep(3000);
		objProfile.clrAddress();
		Thread.sleep(3000);
		String address=Excelutility.getCellData(2, 0);
		objProfile.enterAddress(address);
		String actualText=objProfile.getResult();
		System.out.println("Text="+actualText);
		String expectedText="ABCD,Thiruvanathapuram";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Test case is successfull");
				
	}
	
	

}
