package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.phptravelscustomer.utilities.Excelutility;

public class CuctomerBookingVoucher extends TestBase {
	Customerlogin objLogin; 
	TestClassVoucher objVoucher;
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
	public void verifyVoucher() throws InterruptedException {
		objVoucher= new TestClassVoucher(driver);
		Thread.sleep(3000);
		objVoucher.Bookings();
		Thread.sleep(3000);
		objVoucher.clkVoucher();
		Thread.sleep(3000);
		String expURL=driver.getCurrentUrl();
		System.out.println(expURL);
		String actURL="https://phptravels.net/account/bookings";
		Assert.assertEquals(actURL, expURL);
	}

}
