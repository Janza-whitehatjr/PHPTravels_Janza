package com.phptravelsBaseclass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;



public class AgentToplinks extends TestBase {
	Customerlogin objLogin;
	TestClassAgentToplinks objTop;
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
		Thread.sleep(2000);
		
		
		
		
	}
	@Test
	
	public void verifyHotel() throws InterruptedException {
		objTop= new TestClassAgentToplinks(driver);
		objTop.clkHotel();
		String actualHotelURL= driver.getCurrentUrl();
		System.out.println(actualHotelURL);
		String expectedHotelURL= "https://phptravels.net/hotels";
		Assert.assertEquals(actualHotelURL, expectedHotelURL);
		System.out.println("Verify Hotel link successfull");
		Thread.sleep(3000);
	}
    @Test
	
	public void verifyFights() throws InterruptedException {
		objTop= new TestClassAgentToplinks(driver);
		objTop.clkfights();
		String actualFlightsURL= driver.getCurrentUrl();
		System.out.println(actualFlightsURL);
		String expectedFlightsURL= "https://phptravels.net/flights";
		Assert.assertEquals(actualFlightsURL, expectedFlightsURL);
		System.out.println("Verify Flights link successfull");
		Thread.sleep(3000);
	}
    @Test
	
   	public void verifyTours() throws InterruptedException {
   		objTop= new TestClassAgentToplinks(driver);
   		objTop.clkTours();
   		String actualToursURL= driver.getCurrentUrl();
   		System.out.println(actualToursURL);
   		String expectedToursURL= "https://phptravels.net/tours";
   		Assert.assertEquals(actualToursURL, expectedToursURL);
   		System.out.println("Verify Tours link successfull");
   		Thread.sleep(3000);
   	}
    @Test
	
   	public void verifyTransfers() throws InterruptedException {
   		objTop= new TestClassAgentToplinks(driver);
   		objTop.clkTransfers();
   		String actualTransfersURL= driver.getCurrentUrl();
   		System.out.println(actualTransfersURL);
   		String expectedTransfersURL= "https://phptravels.net/cars";
   		Assert.assertEquals(actualTransfersURL, expectedTransfersURL);
   		System.out.println("Verify Transfers link successfull");
   		Thread.sleep(3000);
   	}
    @Test
	
   	public void verifyVisa() throws InterruptedException {
   		objTop= new TestClassAgentToplinks(driver);
   		objTop.clkVisa();
   		String actualVisaURL= driver.getCurrentUrl();
   		System.out.println(actualVisaURL);
   		String expectedVisaURL= "https://phptravels.net/visa";
   		Assert.assertEquals(actualVisaURL, expectedVisaURL);
   		System.out.println("Verify Visa link successfull");
   		Thread.sleep(3000);
   	}
    @Test
	
   	public void verifyOffers() throws InterruptedException {
   		objTop= new TestClassAgentToplinks(driver);
   		objTop.clkOffers();
   		String actualOffersURL= driver.getCurrentUrl();
   		System.out.println(actualOffersURL);
   		String expectedOffersURL= "https://phptravels.net/offers";
   		Assert.assertEquals(actualOffersURL, expectedOffersURL);
   		System.out.println("Verify offers link successfull");
   		Thread.sleep(3000);
   	}
 @Test
	
   	public void verifyBlog() throws InterruptedException {
   		objTop= new TestClassAgentToplinks(driver);
   		objTop.clkBlog();
   		String actualBlogURL= driver.getCurrentUrl();
   		System.out.println(actualBlogURL);
   		String expectedBlogURL= "https://phptravels.net/blog";
   		Assert.assertEquals(actualBlogURL, expectedBlogURL);
   		System.out.println("Verify Blog link successfull");
   		Thread.sleep(3000);
   	}
    



}
