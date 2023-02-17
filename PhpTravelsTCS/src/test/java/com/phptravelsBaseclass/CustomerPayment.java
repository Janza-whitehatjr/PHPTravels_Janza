package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PHPtravels.customer.CustomerLogin;
import com.phptravelscustomer.utilities.Excelutility;

public class CustomerPayment extends TestBase {
	Customerlogin objLogin;
	TestClasspayment objPay;
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
	public void verifyPayment() throws InterruptedException {
		objPay= new TestClasspayment(driver);
		Thread.sleep(3000);
		objPay.clkFunds();
		Thread.sleep(3000);
		objPay.selectpaypal();
		Thread.sleep(3000);
		objPay.clkPayment();
		Thread.sleep(5000);
		String URLActual= driver.getCurrentUrl();
		System.out.println(URLActual);
		String URLExp="https://phptravels.net/payment/paypal";
		Assert.assertEquals(URLActual, URLExp);
		
	}
	
	
	


}
