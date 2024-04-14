package com.guru.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.base.Baseclass;
import com.guru.qa.pages.AddNewCustomer;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.util.TestUtils;

public class LoginPageTest extends Baseclass {
	public LoginPage loginpage;
	public TestUtils utils;
	
	String SheetName = "Sheet1";
	
	@BeforeMethod
	 public void setUp() throws IOException, InterruptedException {
		Thread.sleep(1000);
		driver=initializedriver();
		loginpage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test(priority=1)
	public String loginPageTitleTest() {
		String title = loginpage.validateloginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
		return title;
		
}
	
	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException {
		Object data [][]= utils.ExcelReader(SheetName);
		return data;
		
	}
	
	@Test(priority=2,dataProvider="getTestData")
	public void validateLoginPageTest(String Username, String Password) {
		
		loginpage.EnterLogin(Username, Password);
		
		
		 
		 
	}
	
	 @AfterMethod
	  public void closeBrowser() throws InterruptedException {
		 loginpage.ClickLogout();
		 
		 Thread.sleep(5000);
		 try {
			 Alert alt = driver.switchTo().alert();
			 String alertText = alt.getText();
			 alt.accept();}
			 catch (UnhandledAlertException e) {
				    e.printStackTrace();
				    
				  }
		 driver.close();
	 }


public AddNewCustomer EnterLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	 }
		 
		 
		
		 
	
	
	
	/*@Test(priority=3)
	public void loginTest() throws InterruptedException {
		Thread.sleep(2000);
		utils = new TestUtils();
		//loginpage.EnterLogin(prop.getProperty("Un"),prop.getProperty("pass"));
		loginpage.EnterLogin(Username, Password);
		    
	}*/
	
	/*@Test(priority=3,enabled=false)
	 public void logoutTest(String Username, String Password,String Result) throws InterruptedException{
		
		 utils = new TestUtils();
		 loginpage.EnterLogin(Username, Password,Result);
		 
		 loginpage.ClickLogout();
		 
		/*try {
		 Alert alt = driver.switchTo().alert();
		 String alertText = alt.getText();
		 alt.accept();}
		 catch (UnhandledAlertException e) {
			    e.printStackTrace();
			  }
		 
	 }*/
	
	
	
	
	


