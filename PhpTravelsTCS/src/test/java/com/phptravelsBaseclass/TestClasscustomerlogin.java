package com.phptravelsBaseclass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PHPtravels.customer.CustomerLogin;
import com.phptravelscustomer.utilities.Excelutility;


public class TestClasscustomerlogin extends TestBase{
	
	
	Customerlogin objLogin;
	
	@Test
	public void verifyinvaliduser() throws IOException, InterruptedException {
		objLogin= new Customerlogin(driver);
		String UserName=Excelutility.getCellData(0, 2);
		String strPassword=Excelutility.getCellData(0, 1);
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
		Thread.sleep(3000);
		objLogin.clruserName();
		objLogin.clrPassword();
		
	}
	@Test
	public void verifyinvalidpass() throws IOException, InterruptedException {
		objLogin= new Customerlogin(driver);
		String Username=Excelutility.getCellData(0, 0);
		String strPassword=Excelutility.getCellData(1, 1);
		objLogin.setUserName(Username);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
		Thread.sleep(3000);
		
		
		objLogin.clruserName();
		objLogin.clrPassword();
	}
	@Test
	public void verifyvalidLogin() throws IOException {
	
		objLogin= new Customerlogin(driver);
		String UserName=Excelutility.getCellData(0, 0);
		String strPassword=Excelutility.getCellData(0, 1);
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		String actualTitle=objLogin.validLogin();
		System.out.println("Actual Title= "+actualTitle);
		String expectedTitle="Dashboard - PHPTRAVELS";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Test case customer login successful");
		
	}
	

}
