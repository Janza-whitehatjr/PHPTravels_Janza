package com.phptravelsBaseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AgentLogin extends TestBase {
	Customerlogin objLogin;
	
	@Test
	public void invalidAgentUser() throws IOException, InterruptedException {
		objLogin= new Customerlogin(driver);
		String UserName=Excelutility.getCellData(3, 2);
		String strPassword=Excelutility.getCellData(3, 1);
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
		Thread.sleep(3000);
		objLogin.clruserName();
		objLogin.clrPassword();
	}
	@Test
	public void invalidAgentPass() throws IOException, InterruptedException {
		objLogin= new Customerlogin(driver);
		String UserName=Excelutility.getCellData(3, 0);
		String strPassword=Excelutility.getCellData(4, 1);
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
		Thread.sleep(3000);
		objLogin.clruserName();
		objLogin.clrPassword();
	}
	
	@Test
	public void validAgent() throws IOException, InterruptedException {
		objLogin= new Customerlogin(driver);
		//String UserName=Excelutility.getCellData(3, 0);
		//String strPassword=Excelutility.getCellData(3, 1);
		String UserName="agent@gmail.com";
		String strPassword="demoagent";
		objLogin.setUserName(UserName);
		objLogin.setPassword(strPassword);
		objLogin.clickLogin();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Tester']")));
		String expectedTitle=driver.getTitle();
		System.out.println(expectedTitle);
		String actualTitle="Dashboard - PHPTRAVELS";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Agent verify login successful");
		
		
	}

}
