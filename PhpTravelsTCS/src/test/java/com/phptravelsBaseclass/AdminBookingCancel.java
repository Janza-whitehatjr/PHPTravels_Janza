package com.phptravelsBaseclass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AdminBookingCancel extends TestBase {
	TestClassAdminlogin objAdmlogin;
	TestClassAdminBookings objcancelBook;
	
	@BeforeTest
	public void adminLog() throws IOException, InterruptedException {
		objAdmlogin= new TestClassAdminlogin(driver);
		String AdUname=Excelutility.getCellData(7, 0);
		String AdPass=Excelutility.getCellData(7, 1);
		objAdmlogin.enterAdminUname(AdUname);
		objAdmlogin.enterAdminPass(AdPass);
		objAdmlogin.clkLog();
		Thread.sleep(3000);
	}
	@Test
	public void cancelBooking() throws InterruptedException {
		objcancelBook=new TestClassAdminBookings(driver);
		String cancelCount=objcancelBook.cancelcout();
		int cancelcountnow=Integer.parseInt(cancelCount);
		int cancelcountexp=cancelcountnow-1;
		System.out.println(cancelcountexp);
		
		objcancelBook.clkBookingCancelled();
		Thread.sleep(2000);
		objcancelBook.clkCancel();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		String cancelCountfinal=objcancelBook.cancelcout();
		int cancelcountactual=Integer.parseInt(cancelCountfinal);
		Assert.assertEquals(cancelcountactual, cancelcountexp);
		
		
		
	}

}
