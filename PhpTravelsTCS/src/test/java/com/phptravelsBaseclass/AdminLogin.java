package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AdminLogin extends TestBase{
	TestClassAdminlogin objAdmlogin;
	@Test
	public void invalidadmUser() throws IOException, InterruptedException {
		objAdmlogin= new TestClassAdminlogin(driver);
		String AdUname=Excelutility.getCellData(7, 2);
		String AdPass=Excelutility.getCellData(7, 1);
		objAdmlogin.enterAdminUname(AdUname);
		objAdmlogin.enterAdminPass(AdPass);
		objAdmlogin.clkLog();
		Thread.sleep(3000);
	}
	@Test
	public void invalidadmPass() throws IOException, InterruptedException {
		objAdmlogin= new TestClassAdminlogin(driver);
		String AdUname=Excelutility.getCellData(7, 0);
		String AdPass=Excelutility.getCellData(8, 1);
		objAdmlogin.enterAdminUname(AdUname);
		objAdmlogin.enterAdminPass(AdPass);
		objAdmlogin.clkLog();
		Thread.sleep(3000);
	}
	@Test
	public void validadm() throws IOException, InterruptedException {
		objAdmlogin= new TestClassAdminlogin(driver);
		String AdUname=Excelutility.getCellData(7, 0);
		String AdPass=Excelutility.getCellData(7, 1);
		objAdmlogin.enterAdminUname(AdUname);
		objAdmlogin.enterAdminPass(AdPass);
		String actualTitle=objAdmlogin.clkAdmLogin();
		System.out.println("Title= "+actualTitle);
		String expectedTitle="Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
