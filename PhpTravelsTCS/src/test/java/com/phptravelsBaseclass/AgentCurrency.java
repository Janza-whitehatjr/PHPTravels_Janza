package com.phptravelsBaseclass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.phptravelscustomer.utilities.Excelutility;

public class AgentCurrency extends TestBase {
	Customerlogin objLogin;
	TestclassAgentCurrency objCurrency;
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
	
	public void verifyCurrencychange() throws InterruptedException {
		objCurrency= new TestclassAgentCurrency(driver);
		objCurrency.clkUSD();
		Thread.sleep(2000);
		objCurrency.clkINR();
		
		WebElement currency=driver.findElement(By.xpath("//button[@type='button'][@id='currency']"));
		String actualText=currency.getText();
		System.out.println("Text= "+actualText);
		String expectedText="INR";
		Assert.assertEquals(actualText, expectedText);
		System.out.println("Verify currency change Successful");
		}

}
