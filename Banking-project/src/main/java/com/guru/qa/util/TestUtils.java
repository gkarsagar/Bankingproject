package com.guru.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.guru.qa.base.Baseclass;
import com.guru.qa.pages.LoginPage;

public class TestUtils extends Baseclass {
	public static String path = ("C:\\Users\\sagar\\eclipse-workspace\\Banking-project\\src\\main\\java\\com\\guru\\qa\\testdata\\TestData.xlsx");
	   
    public static FileInputStream file; 
    public static Workbook wb ;
    static Sheet sheet;
	   
	       public static Object[][] ExcelReader(String SheetName) throws FileNotFoundException {
	    	   
	    	    try {
	    	        file = new FileInputStream(path);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
	    	     
	    	        
	    	     //.getSheet("Sheet1").getLastRow(0).getLastCell(0).getStringCellValue();
	    	      try {
					wb= WorkbookFactory.create(file);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	    	      sheet = wb.getSheet(SheetName);
	    	      
	    	      Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    	      System.out.println(sheet.getLastRowNum() + "----------" + sheet.getRow(0).getLastCellNum());
	    	      
	    	      for (int i = 0; i < sheet.getLastRowNum(); i++) {
	    				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	    					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
	    					 System.out.println(data[i][k]);
	    				}
	    	}
	
	    	      return data;
	  
}
	       public static void takeScreenshotAtEndOfTest() throws IOException {
	   		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   		String currentDir = System.getProperty("user.dir");
	   		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	       }
		

}
