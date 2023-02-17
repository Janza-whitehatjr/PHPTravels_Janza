package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class SupplierLogin  extends TestBase {
	TestClasssupplierLogin objSupLogin;
	
	@Test
	public void invalidsupUser() throws IOException, InterruptedException {
		objSupLogin=new TestClasssupplierLogin(driver);
		String username=Excelutility.getCellData(5, 2);
		String Pswd=Excelutility.getCellData(5, 1);
		objSupLogin.enterUser(username);
		objSupLogin.enterPswd(Pswd);
		objSupLogin.Login();
		Thread.sleep(2000);
	}
	
	@Test
	public void invalidsupPass() throws IOException, InterruptedException {
		objSupLogin=new TestClasssupplierLogin(driver);
		String username=Excelutility.getCellData(5, 0);
		String Pswd=Excelutility.getCellData(6, 1);
		objSupLogin.enterUser(username);
		objSupLogin.enterPswd(Pswd);
		objSupLogin.Login();
		Thread.sleep(2000);
	}
	@Test
	public void validsupplier() throws IOException, InterruptedException {
		objSupLogin=new TestClasssupplierLogin(driver);
		String username=Excelutility.getCellData(5, 0);
		String Pswd=Excelutility.getCellData(5, 1);
		objSupLogin.enterUser(username);
		objSupLogin.enterPswd(Pswd);
		Thread.sleep(5000);
		String actualTitle=objSupLogin.clkSupLogin();
		System.out.println("Title= "+actualTitle);
		String expectedTitle="Dashboard";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	

}
