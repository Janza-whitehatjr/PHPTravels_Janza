package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class SupplierInternals extends TestBase{
	TestClasssupplierLogin objSupLogin;
	TestClassSupplierInternal objSup;
	@BeforeTest
	public void validsup() throws IOException, InterruptedException {
		objSupLogin=new TestClasssupplierLogin(driver);
		String username=Excelutility.getCellData(5, 0);
		String Pswd=Excelutility.getCellData(5, 1);
		objSupLogin.enterUser(username);
		objSupLogin.enterPswd(Pswd);
		objSupLogin.clkSupLogin();
		Thread.sleep(1000);
	}
	@Test
	
	public void verifySalesOverview() {
		objSup= new TestClassSupplierInternal(driver);
		Boolean salesOverview=objSup.displaysales();
		Boolean expectedsales= true;
		System.out.println(salesOverview);
		Assert.assertEquals(salesOverview, expectedsales);
		
	}
	
	@Test
	public void verifyRevenue() {
		objSup= new TestClassSupplierInternal(driver);
		Boolean Revenue=objSup.displayRvenue();
		System.out.println("Revenue= "+Revenue);
		Boolean expectedRevenue=true;
		Assert.assertEquals(Revenue, expectedRevenue);
	}

}
