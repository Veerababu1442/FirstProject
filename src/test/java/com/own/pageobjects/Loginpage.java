package com.own.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.own.testcases.BaseTest;
import com.own.utility.ReadExcelFile;

public class Loginpage {
	WebDriver driver;
	String fileName=System.getProperty("user.dir")+".//TestData//Data.xlsx";
	public Loginpage(WebDriver idriver)
	{
		this.driver=idriver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='Sign in?']")
	 WebElement signlink;
	@FindBy(xpath="//input[@id='user_login']") WebElement Username;
	@FindBy(xpath="//input[@id='user_pass']") WebElement password;
	@FindBy(xpath="//input[@id='wp-submit']") WebElement loginbutton;
	    
	 
	 public void loginuser(String UserName, String Password)
	 {
		 signlink.click();
		 Username.sendKeys(UserName);
		 password.sendKeys(Password);
		 loginbutton.click();
	 }
}
	/* @DataProvider(name="dp")
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
	 }*/
	 

	 

	    // Method to enter username
	 /*   public void enterUsername() {
	        if (Username != null) {
	            Username.sendKeys("Veerababu");
	        } else {
	            System.out.println("Username element is null.");
	        }
	    }

	    // Method to enter password
	    public void enterPassword() {
	        if (Password != null) {
	            Password.sendKeys("Veerababu@1442");
	        } else {
	            System.out.println("Password element is null.");
	        }
	    }

	    // Method to click on the login button
	    public void clickOnLogin() {
	        if (loginbutton != null) {
	            loginbutton.click();
	        } else {
	            System.out.println("Login button element is null.");
	        }
	    } */
	
	/*By signlink=By.xpath("//span[normalize-space()='Sign in?']");
	By Username= By.xpath("//input[@id='user_login']");
	By Password= By.xpath("//input[@id='user_pass']");
	By loginbutton=By.xpath("//input[@id='wp-submit']");
	
	
	public void clickonsignlink()
	{
		driver.findElement(signlink).click();
	}
	
	
	public void EnterUserName()
	{
		driver.findElement(Username).sendKeys("Veerababu");
	}
	
	public void enterpassword()
	{
		driver.findElement(Password).sendKeys("Veerababu@1442");
	}
	
	public void clickonlogin()
	{
		driver.findElement(loginbutton).click();
	}*/
	
