package com.guru.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.Baseclass;



public class LoginPage extends Baseclass {
	
	   @FindBy(xpath="//input[@name='uid']")
       private WebElement Uid; 
	   
	   @FindBy(xpath="//input[@name='password']")
       private WebElement password;
	   
	   @FindBy (xpath="//input[@type='submit']")
	   private WebElement Submit;
	   
	   @FindBy (xpath="//a[normalize-space()='Log out']")
	   private WebElement LogOut;
	   
	   
       WebDriver driver;


       public LoginPage (WebDriver driver) {
    	   
    	   PageFactory.initElements(driver, this);
    	   
    	   this.driver=driver;
       }
       
       
       public AddNewCustomer EnterLogin(String Username,String Password) {
    	   
    	   Uid.sendKeys(Username);
    	   password.sendKeys(Password);
    	   Submit.click();
		return new AddNewCustomer(driver);
       }
       
       
       public void ClickLogout() {
    	   LogOut.click();
       }


	public String validateloginPageTitle() {
		
		return driver.getTitle();
	}
       
       }
       
       
       