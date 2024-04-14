package com.guru.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baseclass {
	  public static WebDriver driver;
	  public  Properties prop;
	   
	public WebDriver initializedriver  () throws IOException {
		
        prop = new Properties();
       
		
		FileInputStream file = new FileInputStream("C:\\Users\\sagar\\eclipse-workspace\\Banking-project\\src\\main\\java\\com\\guru\\qa\\config\\config.properties");
		
		prop.load(file);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\sagar\\OneDrive\\Desktop\\Grid\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			
			ChromeOptions opt = new ChromeOptions();
			opt.addExtensions(new File("C:\\Users\\sagar\\eclipse-workspace\\Banking-project\\src\\test\\resources\\extensions\\AdblockPlus.crx"));
			driver = new ChromeDriver(opt);
			return driver;
			}
		
		

		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		
		return driver;
		
		
		
	}
	
	
	
	
	
	

}
