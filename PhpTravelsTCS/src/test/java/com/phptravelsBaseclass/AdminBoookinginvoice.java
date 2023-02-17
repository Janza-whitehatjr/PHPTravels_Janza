package com.phptravelsBaseclass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AdminBoookinginvoice extends TestBase {
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
    public void Verifyinvoice() throws InterruptedException {
    	objAdmBook=new TestClassAdminBookings(driver);
    	objAdmBook.clkBookings();
    	Alert alert = driver.switchTo().alert();
		alert.accept();
    	Thread.sleep(2000);
    	objAdmBook.clkinvoice();
    	Thread.sleep(3000);
    	String actualURL=driver.getCurrentUrl();
    	System.out.println(actualURL);
    	String expectedURL="https://phptravels.net/api/admin/bookings";
    	Assert.assertEquals(actualURL, expectedURL);
    	
    	
    	
    }


}
