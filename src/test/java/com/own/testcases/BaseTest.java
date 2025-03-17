package com.own.testcases;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.own.pageobjects.Loginpage;
import com.own.utility.ExcelDataProvider;
import com.own.utility.ReadExcelFile;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseTest{
		String fileName=System.getProperty("user.dir")+".//TestData//Data.xlsx";
		public Properties prop;  
	WebDriver driver;
	 Loginpage lt;
	 ReadExcelFile ep=new ReadExcelFile();
	protected String username=ReadExcelFile.getCellValue(fileName,"Login",1,0);//getStringData("Login",1,0);
  protected  String password=ReadExcelFile.getCellValue(fileName,"Login", 1, 1);


		@BeforeClass
		public void setUp() throws IOException, Exception
		{

			 Properties prop=new Properties();
			 FileInputStream	fip = new FileInputStream("C:\\Selenium projects\\Ownproject\\Configuration\\config.properties");
				prop.load(fip);
				
			String browserName=prop.getProperty("browser");
			
		
			if(browserName.equalsIgnoreCase("Chrome"))
				{
					WebDriverManager.chromedriver().setup();
			         driver = new ChromeDriver();
				}
				else if(browserName.equalsIgnoreCase("Firefox"))
				{
					System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
			         driver = new FirefoxDriver();
				}
				else if(browserName.equalsIgnoreCase("IE"))
				{
					System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe");
			         driver = new InternetExplorerDriver();
				}
				else
				{
					System.out.println("We do not support this browser ");
				}
			
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 lt=new Loginpage(driver);
			
		}
		
		
	 @AfterClass
		public void tearDown()
		{
			driver.quit();
		}
	 
		
	}



