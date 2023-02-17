package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class SupPendingToConfirm extends TestBase {
	TestClasssupplierLogin objSupLogin;
	TestClassSupplierInternal objPenCon;
	
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
	public void verifyPendingToConfirm() throws InterruptedException {
		objPenCon= new TestClassSupplierInternal(driver);
		String confirmcount=objPenCon.Confirmcount();
		int confirmcountnow=Integer.parseInt(confirmcount);
		int confirmcountexp = confirmcountnow+1;
		String pendingcount=objPenCon.Pendingcount();
		int pendingcountnow=Integer.parseInt(pendingcount);
		int pencountexp= pendingcountnow-1;
		System.out.println("Expected confirm count = "+confirmcountexp+ " Expected pending count= "+pencountexp);
		objPenCon.clkPending();
		Thread.sleep(2000);
		objPenCon.clkstatus();
		Thread.sleep(2000);
		objPenCon.clkconfirm();
		Thread.sleep(5000);
		objPenCon.clkDashboard();
		Thread.sleep(2000);
		String confirmcountact=objPenCon.Confirmcount();
		int actualconfirmcount=Integer.parseInt(confirmcountact);
		System.out.println(actualconfirmcount);
		String pendingcountactual=objPenCon.Pendingcount();
		int actualpendingcount=Integer.parseInt(pendingcountactual);
		System.out.println("Actual confirm count = "+actualconfirmcount+ " Actual pending count= "+actualpendingcount);
		Assert.assertEquals(actualconfirmcount, confirmcountexp);
		Assert.assertEquals(actualpendingcount, pencountexp);
		
		
	}

}
