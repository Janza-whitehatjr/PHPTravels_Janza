package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AgentSidelinks extends TestBase {
	Customerlogin objLogin;
	TestclassCustomersidelinks objLinks;
	@Test
	public void agentLogin() throws IOException {
		objLogin=new Customerlogin(driver);
		//String UserName=Excelutility.getCellData(3, 0);
		//String strPassword=Excelutility.getCellData(3, 1);
		String UserName="agent@gmail.com";
		String strPassword="demoagent";
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
	}
	
	@Test 
	public void verifyAgentBookings() throws InterruptedException {
		objLinks= new TestclassCustomersidelinks(driver);
		Thread.sleep(3000);
		objLinks.Bookings();
		Thread.sleep(3000);
		String bookingText=objLinks.BookingText();
		String TextExpected="My Bookings";
		Assert.assertEquals(bookingText, TextExpected);
		
		
	}
	 @Test
		public void verifyAgentfundslinks() throws IOException, InterruptedException {
			objLinks= new TestclassCustomersidelinks(driver);
			Thread.sleep(3000);
			objLinks.clkFunds();
			Thread.sleep(3000);
			String fundsText=objLinks.FundsText();
			String Fundtextexp="Add Funds";
			Assert.assertEquals(fundsText, Fundtextexp);
				
		}
	 @Test
		public void verifyAgentProfilelinks() throws IOException, InterruptedException {
			objLinks= new TestclassCustomersidelinks(driver);
			Thread.sleep(3000);
			objLinks.clkProfile();
			Thread.sleep(3000);
			String profileText=objLinks.ProfileText();
			String profiletextexp="Profile Information";
			Assert.assertEquals(profileText, profiletextexp);
			
				
		}


}
