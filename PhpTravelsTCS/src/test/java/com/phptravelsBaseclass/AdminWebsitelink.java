package com.phptravelsBaseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AdminWebsitelink extends TestBase {
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
    public void verifywebsite() throws InterruptedException {
    	objAdmBook=new TestClassAdminBookings(driver);
    	objAdmBook.clkwebsite();
    	Thread.sleep(5000);
    	String actualURL=driver.getCurrentUrl();
    	System.out.println(actualURL);
    	String ExpectedPage="https://phptravels.net/api/admin";
    	Assert.assertEquals(actualURL, ExpectedPage);
     }

}
