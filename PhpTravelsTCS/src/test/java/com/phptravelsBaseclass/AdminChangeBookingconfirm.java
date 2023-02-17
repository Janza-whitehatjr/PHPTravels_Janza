package com.phptravelsBaseclass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AdminChangeBookingconfirm extends TestBase{
	TestClassAdminlogin objAdmlogin;
	TestClassAdminBookings objAdmBook;
	
	@BeforeTest
	
	public void adminLogin() throws IOException, InterruptedException {
		objAdmlogin= new TestClassAdminlogin(driver);
		String AdUname=Excelutility.getCellData(7, 0);
		String AdPass=Excelutility.getCellData(7, 1);
		objAdmlogin.enterAdminUname(AdUname);
		objAdmlogin.enterAdminPass(AdPass);
		objAdmlogin.clkAdmLogin();
		Thread.sleep(3000);
	}
	@Test
	public void verifyBookingStatus() throws InterruptedException {
		objAdmBook=new TestClassAdminBookings(driver);
		String confirmcount=objAdmBook.Confirmcount();
		int confirmcountnow=Integer.parseInt(confirmcount);
		int confirmcountexp = confirmcountnow + 1;
		
		String pendingcount=objAdmBook.Pendingcount();
		int pendingcountnow=Integer.parseInt(pendingcount);
		int pencountexp= pendingcountnow-1;
		System.out.println("Expected confirm count = "+confirmcountexp+ " Expected pending count= "+pencountexp);
		objAdmBook.clkpendingBookings();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		objAdmBook.changeStatus();
		Thread.sleep(3000);
		objAdmBook.selectConfirm();
		Thread.sleep(3000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		String confirmcountactual=objAdmBook.Confirmcount();
		int  actualconfirmcount= Integer.parseInt(confirmcountactual);
		String pendingcountactual=objAdmBook.Pendingcount();
		int actualpendingcount=Integer.parseInt(pendingcountactual);
		Assert.assertEquals(actualconfirmcount, confirmcountexp);
		
		Assert.assertEquals(actualpendingcount, pencountexp);
		
		
		
	}

}
