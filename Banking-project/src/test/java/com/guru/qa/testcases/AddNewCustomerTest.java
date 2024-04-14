package com.guru.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru.qa.base.Baseclass;
import com.guru.qa.pages.AddNewCustomer;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.util.TestUtils;

public class AddNewCustomerTest extends Baseclass {

	public LoginPage loginpage;
	public TestUtils utils;
	AddNewCustomer add = new AddNewCustomer(driver);	
	String SheetName = "Sheet2";
	
	
	    @BeforeMethod
	    public void SetUp() throws IOException {
	    	
	    	driver=initializedriver();
	    	driver.get(prop.getProperty("url"));
	    	loginpage= new LoginPage(driver);
	    	add= loginpage.EnterLogin(prop.getProperty("username"), prop.getProperty("password"));
	        add = new AddNewCustomer(driver);
	    	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	    	
	    	
	    	
	 }
	    
	    @DataProvider
		public Object[][] getTestData() throws FileNotFoundException {
			Object data [][]= utils.ExcelReader(SheetName);
			return data;
			
		}
	
	   @Test(dataProvider="getTestData")
	   
	    public void validateAddNewCustomerTest(String CustomerName,String gender, String doB, String address, String city,String pin, String mob,String email,String Password) throws InterruptedException {
	    	
		   add.CreateNewcustomer(CustomerName, gender,  doB,  address, city, pin,  mob, email, Password); 
		   
	    	
	    }
	   
	   
	   @AfterMethod
	   public void closeBrowser() {
		   
		   driver.close();
	   }
	   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
