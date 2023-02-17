package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AgentHotel extends TestBase {
	TestClassAgentHotel objHotel;
	Customerlogin objLogin;
	@BeforeTest
	public void validAgent() throws IOException, InterruptedException {
		objLogin= new Customerlogin(driver);
		//String UserName=Excelutility.getCellData(3, 0);
		//String strPassword=Excelutility.getCellData(3, 1);
		String UserName="agent@gmail.com";
		String strPassword="demoagent";
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
		
		
		
		
	}
	@Test
	public void searchHotel() throws IOException, InterruptedException {
		objHotel= new TestClassAgentHotel(driver);
		Thread.sleep(3000);
		objHotel.clkHotel();
		Thread.sleep(3000);
		objHotel.clkSearch();
		String city=Excelutility.getCellData(9, 0);
		objHotel.enterCity(city);
		Thread.sleep(3000);
		objHotel.CityName();
		Thread.sleep(3000);
		objHotel.SearchBTN();
		Thread.sleep(5000);
		String actualURL= driver.getCurrentUrl();
		System.out.println(actualURL);
		String expectedURL="https://phptravels.net/hotels/en/usd/dubai/18-02-2023/19-02-2023/1/2/0/US";
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println("Search successfull");
		
		

	}
	

}
