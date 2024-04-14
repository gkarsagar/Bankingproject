package com.guru.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCustomer {

	  @FindBy(xpath="//a[text()='New Customer']")
	  private WebElement Newcustom;
	  
	 // @FindBy(xpath="//div[@class='btn skip']")
	 // private WebElement close;
	  
	  @FindBy(xpath="//p[text()='Add New Customer']")
	  private WebElement heading;
	  
	  @FindBy(xpath="//input[@name='name']")
	  private WebElement Customername;
	  
	  @FindBy(xpath="//input[@type='radio'][1]")
	  private WebElement male;
	  
	  @FindBy(xpath="//input[@type='radio'][2]")
	  private WebElement female;
	  
	  @FindBy(xpath="//input[@name='dob']")
	  private WebElement DoB;
	  
	  @FindBy(xpath="//textarea[@onkeyup='validateAddress();']")
	  private WebElement Address;
	  
	  @FindBy(xpath="//input[@name='city']")
	  private WebElement City;
	  
	  @FindBy(xpath="//input[@name='state']")
	  private WebElement State;
	  
	  @FindBy(xpath="//input[@name='pinno']")
	  private WebElement Pin;
	  
	  @FindBy(xpath="//input[@name='telephoneno']")
	  private WebElement Mob;
	  
	  @FindBy(xpath="//input[@name='emailid']")
	  private WebElement Email;
	  
	  @FindBy(xpath="//input[@name='password']")
	  private WebElement password;
	  
	  @FindBy(xpath="//input[@name='sub']")
	  private WebElement subButton;
	  
	  
	  
	  private WebDriver driver;
	  
	  public AddNewCustomer(WebDriver driver) {
		  
		  PageFactory.initElements(driver, this);
		  
		  this.driver=driver;
	  }
	  
	  


	public void CreateNewcustomer(String CustomerName,String gender, String doB, String address, String city,String pin, String mob,String email,String Password) throws InterruptedException{
		   
		    Newcustom.click();
		    Thread.sleep(5000);
		   // WebElement iframeElement = driver.findElement(By.xpath("//div[@id='interstitial']")); // Replace "interstitial_ad_frame" with the correct id or other locator
		   // driver.switchTo().frame(iframeElement);
		   // iframeElement.click();
		   /* WebDriverWait wait = new WebDriverWait(driver,10);
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.cssSelector(driver.switchTo().frame("iframe")))));
		    close.click();	*/	
	
		     String text= heading.getText();
		    if(text.equals("Add New Customer")) {
		    	 
		       System.out.println(text + "correct page");
		      }
		    else {
		    	System.out.println("Incorrect");
		    }
		    
		   Customername.sendKeys(CustomerName); 
		   if(gender=="male") {
			   
			   male.click();
		   }
		   else {
			   female.click();
		   }
		  
		   DoB.sendKeys(doB);
		   Address.sendKeys(address);
		   City.sendKeys(city);
		   Pin.sendKeys(pin);
		   Mob.sendKeys(mob);
		   Email.sendKeys(email);
		   password.sendKeys(Password);
		    
		 }
	  
}
