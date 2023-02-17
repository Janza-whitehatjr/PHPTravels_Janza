package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class supplierLinks extends TestBase {
	TestClasssupplierLogin objSupLogin;
	TestClassSupLinks objSuplinks;
	
	@BeforeTest
	
	public void suplogin() throws IOException, InterruptedException {
		objSupLogin=new TestClasssupplierLogin(driver);
		String username=Excelutility.getCellData(5, 0);
		String Pswd=Excelutility.getCellData(5, 1);
		objSupLogin.enterUser(username);
		objSupLogin.enterPswd(Pswd);
		objSupLogin.clkSupLogin();
		Thread.sleep(2000);
	}
	
	@Test
	public void VerifyManageTours() throws InterruptedException {
		objSuplinks=new TestClassSupLinks(driver);
		objSuplinks.clkTours();
		Thread.sleep(2000);
		objSuplinks.clkToursinside();
		Thread.sleep(2000);
		String managetours=objSuplinks.clkManageTours();
		System.out.println(managetours);
		String Expected="Tours Management";
		Assert.assertEquals(managetours, Expected);
		
	}
	
	@Test
	public void verifyToursExtras() throws InterruptedException {
		objSuplinks=new TestClassSupLinks(driver);
		objSuplinks.clkTours();
		Thread.sleep(2000);
		objSuplinks.clkToursinside();
		Thread.sleep(2000);
		String toursextras=objSuplinks.clkToursextras();
		System.out.println(toursextras);
		String Expectedextras="Extras Management";
		Assert.assertEquals(toursextras, Expectedextras);
	}
	@Test
	
	public void verifysupBookings() {
		objSuplinks=new TestClassSupLinks(driver);
		objSuplinks.clkBookings();
		String actualURL=driver.getCurrentUrl();
		System.out.println(actualURL);
		String expectedURL="https://phptravels.net/api/supplier/bookings";
		Assert.assertEquals(actualURL, expectedURL);
			
		
	}

}
