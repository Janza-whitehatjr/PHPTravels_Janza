package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PHPtravels.customer.CustomerLogin;
import com.phptravelscustomer.utilities.Excelutility;

public class CustomerLinks extends TestBase {
	TestclassCustomersidelinks objLinks;
	Customerlogin objLogin;
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
		public void verifyBookingslinks() throws IOException, InterruptedException {
			objLinks= new TestclassCustomersidelinks(driver);
			Thread.sleep(3000);
			objLinks.Bookings();
			Thread.sleep(3000);
			String bookingText=objLinks.BookingText();
			String TextExpected="My Bookings";
			Assert.assertEquals(bookingText, TextExpected);
			
			
				
		}
	 @Test
		public void verifyfundslinks() throws IOException, InterruptedException {
			objLinks= new TestclassCustomersidelinks(driver);
			Thread.sleep(3000);
			objLinks.clkFunds();
			Thread.sleep(3000);
			String fundsText=objLinks.FundsText();
			String Fundtextexp="Add Funds";
			Assert.assertEquals(fundsText, Fundtextexp);
				
		}
	 @Test
		public void verifyProfilelinks() throws IOException, InterruptedException {
			objLinks= new TestclassCustomersidelinks(driver);
			Thread.sleep(3000);
			objLinks.clkProfile();
			Thread.sleep(3000);
			String profileText=objLinks.ProfileText();
			String profiletextexp="Profile Information";
			Assert.assertEquals(profileText, profiletextexp);
			
				
		}



}
