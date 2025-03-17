package com.own.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.own.pageobjects.Loginpage;
import com.own.utility.ReadExcelFile;

public class Logintestcase extends BaseTest {
	
	String fileName=System.getProperty("user.dir")+".//TestData//Data.xlsx";
	  Loginpage lp;
	
	@Test(dataProvider="dp")
	public void loginwithvalid(String UserName, String Password) throws Exception, InterruptedException
	{
		lp=new Loginpage (driver);
		// WebDriverWait wait = new WebDriverWait(driver, 20);  // Use WebDriverWait to wait for elements
	     //   wait.until(ExpectedConditions.visibilityOf(lp.signlink));  // Wait until the sign link is visible
	    Thread.sleep(500);
		lp.loginuser(UserName, Password);
	}
	 @DataProvider(name="dp")
	 public String[][] logindataprovider()
	 {
		 int row=ReadExcelFile.getRowCount(fileName, "Login");
		 int col=ReadExcelFile.getColCount(fileName, "Login");
		 String[][] data=new String[row-1][col];
		 for(int i=1; i<row;i++)
		 {
			 for(int j=0;j<col;j++) {
				 
				 data[i-1][j]=ReadExcelFile.getCellValue(fileName, "Login", i, j);
			 }
		 }
		 return data;
	 }
}
